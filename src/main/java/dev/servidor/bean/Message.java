package dev.servidor.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

@Entity
public class Message implements Serializable {
	
        @Id
        @Column(name = "ID")
	private Long id;
        
	@Column(name = "MESSAGE")
	private String message;
        
	@Column(name = "PROFILE")
	private Profile profile;
        
	@Column(name = "DATE")
        @Temporal(javax.persistence.TemporalType.DATE)
	private Date date;

	public Message() {
		super();
	}

	public Message(Long id, String message, Profile profile, Date date) {
		super();
		this.id = id;
		this.message = message;
		this.profile = profile;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}	
	
}
