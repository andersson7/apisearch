package com.fri.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Andersson
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseDTO {
    
    private String kind;
    private String country;
    private String name;
    private String artistId;
    private Double collectionPrice;
    private String wrapperType;
    private String origin;
}
