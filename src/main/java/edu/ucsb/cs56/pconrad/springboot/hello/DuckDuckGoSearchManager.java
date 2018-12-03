package edu.ucsb.cs56.pconrad.springboot.hello;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import javax.tools.JavaFileObject;

import com.fasterxml.jackson.core.JsonParser;

public class DuckDuckGoSearchManager {

    public static void search(SearchQuery query) throws Exception {
        System.out.println("starting query!");

        //https://api.duckduckgo.com/?no_redirect=1&no_html=1&skip_disambig=1&q=DuckDuckGo
        URL url = new URL("https://api.duckduckgo.com/?q=DuckDuckGo&format=json");

        // Set up connects

        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestProperty("User-Agent", "UCSB/1.0");
        // connection.setRequestMethod("GET");
        // connection.setRequestProperty("Content-Type", "application/json");
        System.out.println(connection.getResponseMessage());

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
		JavaFileObject json = parser.parse(content.toString()).getAsJsonObject();

        // Print results



        System.out.println("did get response: " + content.toString());
    }
    
}