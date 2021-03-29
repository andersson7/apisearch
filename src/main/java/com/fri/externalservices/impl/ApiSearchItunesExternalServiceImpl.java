package com.fri.externalservices.impl;

import com.fri.dto.ResponseDTO;
import com.fri.externalservices.ApiSearchItunesExternalService;
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
public class ApiSearchItunesExternalServiceImpl implements ApiSearchItunesExternalService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Object search(String term) {

        Object responseItunes = new Object();
        
        ArrayList<ResponseDTO> responses = new ArrayList<>();
        
        try{
            
            RestTemplate restTemplate = new RestTemplate();
            String url = "https://itunes.apple.com/search?term="+ term;
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
            
            JSONObject obj = new JSONObject(responseEntity.getBody());
            JSONArray results = obj.getJSONArray("results");
            
            for(int i = 0; i<results.length(); i++){
                JSONObject object =  results.getJSONObject(i);
                ResponseDTO responseDTO = new ResponseDTO();
                responseDTO.setKind(object.has("kind") ? object.getString("kind") : "undefined");
                responseDTO.setCountry(object.has("country") ? object.getString("country") : "undefined" );
                responseDTO.setName(object.has("description") ? object.getString("description") : 
                        object.has("trackName") ? object.getString("trackName") : "undefined" );
                responseDTO.setArtistId(object.has("artistId") ? object.getString("artistId") : "undefined" );
                responseDTO.setCollectionPrice(object.has("collectionPrice") ? object.getDouble("collectionPrice") : 0);
                responseDTO.setWrapperType(object.has("wrapperType") ? object.getString("wrapperType") : "undefined" );
                responseDTO.setOrigin("Itunes " + url);
                responses.add(responseDTO);
            }
            
            responseItunes = responses;
              
        }catch(Exception e){
            logger.error("Error search ApiSearchItunesExternalServiceImpl", e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
        
        return responseItunes;
        
    }

}
