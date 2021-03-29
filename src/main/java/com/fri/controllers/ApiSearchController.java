package com.fri.controllers;

import com.fri.dto.ApiResponseDTO;
import com.fri.util.Meta;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fri.services.ApiSearchService;

/**
 *
 * @author Andersson
 */
@RestController
public class ApiSearchController {

    @Autowired
    private ApiSearchService apiSearchService;

    @GetMapping("/hi")
    public ApiResponseDTO hi() {
        return new ApiResponseDTO(new Meta(UUID.randomUUID().toString(), "OK", 200)," Welcome to ApiSearchService Use the /search resource; example http://localhost:8080/api/v1/search?term=jack ");
    }
    
    @GetMapping("/search")
    public ApiResponseDTO search(@RequestParam String term ) {
        return new ApiResponseDTO(new Meta(UUID.randomUUID().toString(), "OK", 200), apiSearchService.search(term));
    }  

}
