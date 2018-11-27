package edu.ucsb.cs56.pconrad.springboot.hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class HelloRestController {

    @PostMapping("/search/{engine}/{query}")
    public String index(@PathVariable String engine, @PathVariable String query) {
    	// query holds what the user wants to search
    	// engine holds the name of the selected engine
    	// this function passes back a string to the front end
    	// note: the return type of this function doesn't need to be a string
    	return "STUB";
	}
}