package com.jeegox.glio.dto;

import java.io.Serializable;

/**
 *
 * @author j2esus
 */
public final class CompanyDTO implements Serializable{
    private Integer id;
    private String name;

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
}
