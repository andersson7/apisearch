package com.fri.externalservices;

import org.springframework.stereotype.Service;

/**
 *
 * @author Andersson
 */
@Service
public interface ApiSearchItunesExternalService {
    public Object search(String term);
}
