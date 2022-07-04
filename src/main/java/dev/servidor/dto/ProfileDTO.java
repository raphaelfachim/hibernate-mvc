/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.servidor.dto;

import java.util.Date;

/**
 *
 * @author raphael.fachim
 */
public class ProfileDTO {
    
    private String fullName;
    
    private Date created;

    public ProfileDTO() {
    }

    public ProfileDTO(String fullName, Date created) {
        this.fullName = fullName;
        this.created = created;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
    
}
