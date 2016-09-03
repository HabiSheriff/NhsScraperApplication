package com.nhs.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SearchController {

    @RequestMapping("/")
    public String home(Model model) {
    	SearchResults searchResults = new SearchResults();
    	searchResults.setSearchText("");
    	
    	model.addAttribute("searchResults", searchResults);
        return "home";
    }
    
    @RequestMapping("/search")
    public String search(final HttpServletRequest request, final HttpServletResponse response, Model model) {
    	System.out.println("search text ===>" + request.getParameter("searchText") );
    	SearchResults searchResults = new SearchResults();
    	searchResults.setSearchText(request.getParameter("searchText"));
    	
    	model.addAttribute("searchResults", searchResults);
        return "home";
    }
}
