package com.fri.services.impl;

import com.fri.externalservices.ApiSearchItunesExternalService;
import com.fri.externalservices.ApiSearchTvMazeExternalService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fri.services.ApiSearchService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author Andersson
 */
@Service
public class ApiSearchServiceImpl implements ApiSearchService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final String MENSAJEBADREQUEST = "La información que envió no tiene el formato correcto.";
    
    @Autowired
    private ApiSearchItunesExternalService apiSearchItunesExternalService;
    
    @Autowired
    private ApiSearchTvMazeExternalService apiSearchTvMazeExternalService;
    

    @Override
    public Object search(String term) {
 
        ArrayList<Object> objects = new ArrayList<>();
        
        try {
            
            objects.add(apiSearchItunesExternalService.search(term));
            objects.add(apiSearchTvMazeExternalService.search(term));
                   
        } catch (Exception e) {
            logger.error("Error ApiSearchServiceImpl search", e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, MENSAJEBADREQUEST);
        }
        
        return objects;
        
    }
    

}
