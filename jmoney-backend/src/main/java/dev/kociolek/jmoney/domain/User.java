package dev.kociolek.jmoney.domain;

import java.util.Set;
import java.util.UUID;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
	
	@Column(nullable = false, length = 4096)
	private String password;

	@NotNull
	private boolean enabled;

	@Enumerated(EnumType.STRING)
    @ElementCollection(targetClass= Role.class)
	@NotNull
	private Set<Role> roles;
	
	public User(String name, String email, String password, boolean enabled, Set<Role> roles) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.email = email;
		this.password = getEncodedPassword(password);
		this.enabled = enabled;
		this.roles = roles;
	}

	public User(){}

	private String getEncodedPassword(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
	}
	
}