package edu.ucsb.cs56.pconrad.springboot.hello;

import java.net.*;
import java.util.ArrayList;
import java.io.*;
import javax.net.ssl.HttpsURLConnection;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class DuckDuckGoSearchManager {

    public static ArrayList<SearchResult> search(SearchQuery query) throws Exception {

        // Information on the api can be found here: https://api.duckduckgo.com/api
        // Doesn't return exact search results. Instead, it queries their instant answer api.
        // As a result, we display the instant answer they provide and then their related results.

        URL url = new URL("https://api.duckduckgo.com/?format=json" + "&q=" + URLEncoder.encode(query.getUserEntry(), "UTF-8"));

        // Set up connection

        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestProperty("User-Agent", "UCSB/1.0");

        // Read output

        BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = input.readLine()) != null) {
            content.append(inputLine);
        }
        input.close();
        connection.disconnect();

        // Parse results

        JsonParser parser = new JsonParser();
        JsonObject json = parser.parse(content.toString()).getAsJsonObject();

        // Get instant answer

        String abstractUrl = json.get("AbstractURL").toString();
        String abstractTitle = json.get("AbstractSource").toString();
        String abstractHeading = json.get("Heading").toString();

        SearchResult abstractObject = new SearchResult(abstractTitle, abstractHeading, abstractUrl);
        ArrayList<SearchResult> results = new ArrayList<SearchResult>();
        results.add(abstractObject);

        // Get related results

        JsonArray relatedResults = json.getAsJsonArray("RelatedTopics");
        for (int i = 0; i < relatedResults.size(); i++) {
            JsonElement element = relatedResults.get(i);
            if (!element.isJsonObject()) {
                continue;
            }
            JsonObject object = (JsonObject)element;
            if (!object.has("FirstURL") || !object.has("Text")) {
                continue;
            }
            String relatedUrl = object.get("FirstURL").toString();
            String relatedDetails = object.get("Text").toString();
            results.add(new SearchResult(relatedDetails, relatedDetails, relatedUrl));
        }

        // Return results

		return results;

    }
    
}
