package com.jeegox.glio;

import com.jeegox.glio.constants.Environment;
import com.jeegox.glio.dto.UserResponse;
import com.jeegox.glio.exception.JeegoxException;
import com.jeegox.glio.util.JsonConverter;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import javax.ws.rs.core.Response;

/**
 *
 * @author j2esus <jesus.vargas@jeegox.com>
 */
public final class Glio {
    private String address = "http://localhost:8080/glio/json/";
    
    private Client client = Client.create();
    
    public Glio(Environment environment){
        if(Environment.PRODUCTION.equals(environment)){
            address = "https://apps.jeegox.com:8181/glio/json/";
        }
    }
    
    public UserResponse login(String username, String password) throws JeegoxException{
        WebResource webResource  = client.resource(address + "login?username="+username+
                "&password="+password);
        ClientResponse response = webResource.accept("application/json").post(ClientResponse.class);
        if(response.getStatus() != Response.Status.OK.getStatusCode()){
            throw new JeegoxException("HTTP Error: " + response.getStatus());
        }
        String result = response.getEntity(String.class);
        return JsonConverter.login(result);
    }
}
