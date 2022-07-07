package dev.servidor.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

@Entity
public class Message implements Serializable {
	
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ID")
	private Long id;
        
	@Column(name = "MESSAGE_TEXT")
	private String message;
        
        @ManyToOne(cascade = CascadeType.PERSIST)
        @JoinColumn(name="PROFILE_ID")
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

        public Message(String message, Profile profile, Date date) {
            this.message = message;
            this.profile = profile;
            this.date = date;
        }

        public Message(String message, Date date) {
            this.message = message;
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
