package dev.kociolek.jmoney.domain.operation;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
public class Transfer {

	@Id
	@GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	@NotNull
	private String outcomingAccount;
	@NotNull
	private String incomingAccount;
	@NotNull
	private BigDecimal amount;
	@NotNull
	private String operationDetail;
	
}