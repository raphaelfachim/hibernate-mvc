package dev.servidor.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

@Entity
public class Profile implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
        
	@Column(name = "NAME")
	private String name;
        
	@Column(name = "LAST_NAME")
	private String lastName;
        
	@Column(name = "CREATION_DATE")
        @Temporal(javax.persistence.TemporalType.DATE)
	private Date creationDate;
        
	@Column(name = "BIRTH_DATE")
        @Temporal(javax.persistence.TemporalType.DATE)
	private Date birthDate;
        
        @OneToMany(mappedBy = "profile")
	private Collection<Message> messages = new ArrayList();

	public Profile() {
		super();
	}

        public Profile(String name, String lastName, Date creationDate, Date birthDate) {
            this.name = name;
            this.lastName = lastName;
            this.creationDate = creationDate;
            this.birthDate = birthDate;
        }

	public Profile(Long id, String name, String lastName, Date creationDate, Date birthDate, Collection<Message> messages) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.creationDate = creationDate;
		this.birthDate = birthDate;
		this.messages = messages;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Collection<Message> getMessages() {
		return messages;
	}

	public void setMessages(Collection<Message> messages) {
		this.messages = messages;
	}
	
}
