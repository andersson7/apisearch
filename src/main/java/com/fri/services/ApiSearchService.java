package com.fri.services;

import org.springframework.stereotype.Service;

/**
 *
 * @author Andersson
 */
@Service
public interface ApiSearchService {
    public Object search(String term);
}
