package com.fri.externalservices;

import org.springframework.stereotype.Service;

/**
 *
 * @author Andersson
 */
@Service
public interface ApiSearchTvMazeExternalService {
    public Object search(String term);
}
