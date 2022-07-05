/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.servidor.dto;

import java.util.Date;

public class MessageDTO {
    
    private String fullName;
    
    private String message;
    
    private Date created;

    public MessageDTO() {
    }

    public MessageDTO(String fullName, String message, Date created) {
        this.fullName = fullName;
        this.message = message;
        this.created = created;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
    
}
