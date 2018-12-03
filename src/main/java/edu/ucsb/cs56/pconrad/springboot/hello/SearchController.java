package edu.ucsb.cs56.pconrad.springboot.hello;

import edu.ucsb.cs56.pconrad.springboot.hello.SearchQuery;
import edu.ucsb.cs56.pconrad.springboot.hello.SearchResult;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;

import java.util.stream.Collectors;
import java.util.ArrayList;
import javax.validation.Valid;


@RestController
public class SearchController{

	// Used https://www.mkyong.com/spring-boot/spring-boot-ajax-example/ for reference
	@PostMapping("/search")
    public ResponseEntity<?> getSearchResult(@Valid @RequestBody String rawQuery, Errors errors){
		SearchQuery query = new SearchQuery(rawQuery);
		String errorMsg = new String();
		// We will eventually return something more complex than a String
		ArrayList<String> results = new ArrayList<String>();

		if(errors.hasErrors()) {
			errorMsg = (errors.getAllErrors().stream().map(x->x.getDefaultMessage()).collect(Collectors.joining(",")));
			return ResponseEntity.badRequest().body(errorMsg);
		}

		if(query.getEngine().equals("Google")){
			//  this is just an example. Individual search api functions should return an ArrayList of Strings, formatted as
			//  "title:subtitle:URL" which can be easily achieved with the toSplittableString() method in the SearchResult Object.
			// then set results = YourEngineFunctionThatReturnsAnArrayListOfStrings() and it should work.
			SearchResult resultsObject = new SearchResult("title", "subtitle","URL");
			results.add(resultsObject.toSplittableString());
		}
		else if(query.getEngine().equals("DuckDuckGo")){
			//results = "Searched " + query.getUserEntry() + " with DuckDuckGo";
		}
		else if(query.getEngine().equals("Bing")){
			//results = "Searched " + query.getUserEntry() + " with Bing";
		}

		return ResponseEntity.ok(results);
	}
}
