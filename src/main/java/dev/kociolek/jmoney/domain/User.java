package dev.kociolek.jmoney.domain;

import java.util.Set;
import java.util.UUID;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
public class User {
	
	@Id
	@GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	@NotNull
	@Size(min = 3, max = 15, message = "Name must be between 3 and 15 characters")
	private String name;
	
	@NotNull
	@Email(message = "Email should be valid")
	private String email;
	
	@NotNull
	private String password;
	
	@Enumerated(EnumType.STRING)
    @ElementCollection(targetClass=Role.class)
	@NotNull
	private Set<Role> roles;
	
	public User(String name, String email, String password, Set<Role> roles) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	
}