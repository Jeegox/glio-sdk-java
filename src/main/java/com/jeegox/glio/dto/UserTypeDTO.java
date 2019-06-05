package com.jeegox.glio.dto;

import java.io.Serializable;

/**
 *
 * @author j2esus
 */
public final class UserTypeDTO implements Serializable{
    private Integer id;
    private String name;
    private String status;
    
    public UserTypeDTO(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
