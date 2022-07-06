/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.servidor.dto;

import java.util.Date;

public class ProfileDTO {
    
    private Long id;
    
    private String fullName;
    
    private Date created;
    
    private Date bithDate;

    public ProfileDTO() {
    }

    public ProfileDTO(Long id, String fullName, Date created, Date birthDate) {
        this.id = id;
        this.fullName = fullName;
        this.created = created;
        this.bithDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getBithDate() {
        return bithDate;
    }

    public void setBithDate(Date bithDate) {
        this.bithDate = bithDate;
    }
    
}
