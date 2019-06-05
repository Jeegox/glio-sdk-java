package com.jeegox.glio.dto;

import com.jeegox.glio.constants.StatusResponse;
import java.io.Serializable;

/**
 *
 * @author j2esus
 */
public class GenericResponse implements Serializable{
    protected StatusResponse statusResponse;
    protected String message;

    public StatusResponse getStatusResponse() {
        return statusResponse;
    }

    public void setStatusResponse(StatusResponse statusResponse) {
        this.statusResponse = statusResponse;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }    
    
}
