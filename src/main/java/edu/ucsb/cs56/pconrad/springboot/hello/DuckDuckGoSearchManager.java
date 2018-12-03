package edu.ucsb.cs56.pconrad.springboot.hello;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class DuckDuckGoSearchManager {

    public static void search(SearchQuery query) throws Exception {
        System.out.println("starting query!");

        //https://api.duckduckgo.com/?no_redirect=1&no_html=1&skip_disambig=1&q=DuckDuckGo
        URL url = new URL("https://api.duckduckgo.com/?no_redirect=1&no_html=1&skip_disambig=1&q=DuckDuckGo");

        // Set up connects

        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        // connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json");
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

        // Print results

        System.out.println("did get response: " + content.toString());
    }
    
}