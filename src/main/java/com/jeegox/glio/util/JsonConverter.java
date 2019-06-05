package com.jeegox.glio.util;

import com.jeegox.glio.constants.StatusResponse;
import com.jeegox.glio.dto.CompanyDTO;
import com.jeegox.glio.dto.UserDTO;
import com.jeegox.glio.dto.UserResponse;
import com.jeegox.glio.dto.UserTypeDTO;
import org.json.JSONObject;

/**
 *
 * @author j2esus <jesus.vargas@jeegox.com>
 */
public final class JsonConverter {

    //{"statusResponse":"FAILURE","message":"El nombre de usuario y/o contraseña son incorrectos.",
    //    "userDTO":{"id":0,"username":"","token":"","session":"","company":{"id":0,"name":""},"userType":{"id":0,"name":"","status":""}}
    //}
    public static UserResponse login(String json) {
        UserResponse userResponse = new UserResponse();
        UserDTO userDTO = new UserDTO();
        CompanyDTO companyDTO = new CompanyDTO();
        UserTypeDTO userType = new UserTypeDTO();

        JSONObject jsonObject = new JSONObject(json);
        StatusResponse statusResponse = StatusResponse.valueOf(jsonObject.getString("statusResponse"));
        String message = jsonObject.getString("message");

        userResponse.setStatusResponse(statusResponse);
        userResponse.setMessage(message);

        //user
        JSONObject jsonUser = jsonObject.getJSONObject("userDTO");
        userDTO.setId(jsonUser.getInt("id"));
        userDTO.setUsername(jsonUser.getString("username"));
        userDTO.setToken(jsonUser.getString("token"));
        userDTO.setSession(jsonUser.getString("session"));
        
        //company
        JSONObject JsonCompany = jsonUser.getJSONObject("company");
        companyDTO.setId(JsonCompany.getInt("id"));
        companyDTO.setName(JsonCompany.getString("name"));
        
        //userType
        JSONObject jsonUserType = jsonUser.getJSONObject("userType");
        userType.setId(jsonUserType.getInt("id"));
        userType.setName(jsonUserType.getString("name"));
        userType.setStatus(jsonUserType.getString("status"));
        
        userDTO.setCompany(companyDTO);
        userDTO.setUserType(userType);
        userResponse.setUserDTO(userDTO);
        return userResponse;
    }
}
