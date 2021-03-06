package dev.kociolek.jmoney.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
public class Account {

	@Id
	@GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	
	@NotNull
	@Size(min = 3, max = 15, message = "Name must be between 3 and 15 characters")
	private String name;
	
	@NotNull
	private BigDecimal balance;
	
}
