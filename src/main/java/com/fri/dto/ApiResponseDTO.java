package com.fri.dto;

import com.fri.util.Meta;
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
public class ApiResponseDTO {
    
    private Meta meta;
    private Object data;

    public ApiResponseDTO(Meta meta) {
        this.meta = meta;
    } 
    
}
