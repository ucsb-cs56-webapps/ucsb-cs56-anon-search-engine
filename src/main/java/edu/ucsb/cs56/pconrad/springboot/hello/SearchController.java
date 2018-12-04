package edu.ucsb.cs56.pconrad.springboot.hello;

import java.net.*;
import java.util.*;
import java.io.*;
import javax.net.ssl.HttpsURLConnection;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController{

    static String bingSubscriptionKey = "";
    static String binghost = "https://api.cognitive.microsoft.com";
    static String bingpath = "/bing/v7.0/search";

	// Used https://www.mkyong.com/spring-boot/spring-boot-ajax-example/ for reference
	@PostMapping("/search")
    public ResponseEntity<?> getSearchResult(@Valid @RequestBody String rawQuery, Errors errors){
		SearchQuery query = new SearchQuery(rawQuery);
		String errorMsg = new String();
		// We will eventually return something more complex than a String
		ArrayList<SearchResult> results = new ArrayList<SearchResult>();

		if(errors.hasErrors()) {
			errorMsg = (errors.getAllErrors().stream().map(x->x.getDefaultMessage()).collect(Collectors.joining(",")));
			return ResponseEntity.badRequest().body(errorMsg);
		}

		// API's should return an ArrayList<SearchResult> Object.

		if(query.getEngine().equals("Google")){
			SearchResult resultsObject = new SearchResult("title", "subtitle","URL");
			results.add(resultsObject);
		}
		else if(query.getEngine().equals("DuckDuckGo")){
			//results = "Searched " + query.getUserEntry() + " with DuckDuckGo";
		}
		else if(query.getEngine().equals("Bing")){
			String file ="bingAPI_key.txt";
	        try {
	            BufferedReader reader = new BufferedReader(new FileReader(file));
	            bingSubscriptionKey = reader.readLine();
	            reader.close();
	        }
	        catch (java.io.IOException e) {
	            System.err.print("Caught IOException");
	        }

	        // Confirm the subscriptionKey is valid.
	        if (bingSubscriptionKey.length() != 32) {
	            System.out.println("Invalid Bing Search API subscription key!");
	            System.exit(1);
	        }

	        String searchTerm = query.getUserEntry();	
	        ArrayList<SearchResult> bingResults = BingSearch.getResult(searchTerm, binghost, bingpath, bingSubscriptionKey);
		    results.addAll(bingResults);
		}

		ArrayList<String> stringResults = new ArrayList<String>();

		for(int i = 0; i < results.size(); i++) {
			stringResults.add(results.get(i).toSplittableString());
		}

		return ResponseEntity.ok(stringResults);
	}
}
