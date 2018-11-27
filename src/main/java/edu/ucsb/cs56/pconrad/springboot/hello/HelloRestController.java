package edu.ucsb.cs56.pconrad.springboot.hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class HelloRestController {

    @PostMapping("/search/{engine}/{query}")
    public String index(@PathVariable String engine, @PathVariable String query) {
        return engine + "\n" + query;
	}
}
