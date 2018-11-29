package edu.ucsb.cs56.pconrad.anon_search_engine;

import edu.ucsb.cs56.pconrad.anon_search_engine.SearchQuery;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;

import java.util.stream.Collectors;
import javax.validation.Valid;

@RestController
public class SearchController{

	// Used https://www.mkyong.com/spring-boot/spring-boot-ajax-example/ for reference
	@PostMapping("/search")
    public ResponseEntity<?> getSearchResult(@Valid @RequestBody String rawQuery, Errors errors){
		SearchQuery query = new SearchQuery(rawQuery);
		String errorMsg = new String();
		// We will eventually return something more complex than a String
		String results = new String();
		
		if(errors.hasErrors()) {
			errorMsg = (errors.getAllErrors().stream().map(x->x.getDefaultMessage()).collect(Collectors.joining(",")));
			return ResponseEntity.badRequest().body(errorMsg);
		}

		if(query.getEngine().equals("Google")){
			results = "Searched " + query.getUserEntry() + " with Google";
		}
		else if(query.getEngine() == "DuckDuckGo"){
			results = "Searched " + query.getUserEntry() + " with DuckDuckGo";
		}
		else if(query.getEngine() == "Bing"){
			results = "Searched " + query.getUserEntry() + " with Bing";
		}

		return ResponseEntity.ok(results);
	}
}