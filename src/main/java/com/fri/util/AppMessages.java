package com.fri.util;

import lombok.Data;

/**
 *
 * @author Andersson
 */
@Data
public class AppMessages {

    private AppMessages() {
        throw new IllegalStateException("AppMessages class");
    }

    public static final String CLIENT_ERROR = "CLIENT_ERROR";
    public static final String ERROR = "SERVER_ERROR";
    public static final String UNAUTHORISED_MESSAGE = "Usted no está autorizado para acceder este recurso.";

}
