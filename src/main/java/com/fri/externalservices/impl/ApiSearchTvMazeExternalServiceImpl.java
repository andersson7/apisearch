package com.fri.externalservices.impl;

import com.fri.dto.ResponseDTO;
import com.fri.externalservices.ApiSearchTvMazeExternalService;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
/**
 *
 * @author Andersson
 */
@Service
public class ApiSearchTvMazeExternalServiceImpl implements ApiSearchTvMazeExternalService{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Object search(String term) {
 
        ArrayList<ResponseDTO> responses = new ArrayList<>();
        Object responseTvMaze = new Object();
        
        try{
            
            RestTemplate restTemplate = new RestTemplate();
            String url = "http://api.tvmaze.com/search/shows?q="+ term;
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
            
            JSONArray results = new JSONArray(responseEntity.getBody());
            
            
            for(int i = 0; i<results.length(); i++){
                JSONObject objectJson =  results.getJSONObject(i);
                JSONObject object = objectJson.getJSONObject("show");
                JSONObject network ;
                
                String countryName = "undefined";
                
                if(object.has("network") && !object.isNull("network")) {              
                    network = object.getJSONObject("network");
                    JSONObject country = network.getJSONObject("country");
                    countryName = country.getString("name");
                }
                
                ResponseDTO responseDTO = new ResponseDTO();
                responseDTO.setKind(object.has("type") ? object.getString("type") : "undefined");
                responseDTO.setCountry(countryName);
                responseDTO.setName(object.has("name") ? object.getString("name") : "undefined" );
                responseDTO.setArtistId(object.has("id") ? object.getString("id") : "undefined" );
                responseDTO.setCollectionPrice(0.0);
                responseDTO.setWrapperType("undefined");
                responseDTO.setOrigin("TvMaze " + url);
                responses.add(responseDTO);
            }
            
            responseTvMaze = responses;
            
        }catch(Exception e){
            logger.error("Error search ApiSearchTvMazeExternalServiceImpl", e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
        
        return responseTvMaze;
        
    }

}
