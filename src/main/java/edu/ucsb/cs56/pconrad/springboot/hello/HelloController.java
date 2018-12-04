package edu.ucsb.cs56.pconrad.springboot.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

	@RequestMapping("/search")
    public String page1() {
        return "search";
    }

	@RequestMapping("/chooseSearchEngines")
	public String page2() {
        return "chooseSearchEngines";
    }

	@RequestMapping("/page3")
	public String page3() {
        return "page3";
    }


}
