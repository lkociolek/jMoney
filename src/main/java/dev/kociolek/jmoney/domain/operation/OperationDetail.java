package dev.kociolek.jmoney.domain.operation;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
public class OperationDetail {
	@Id
	@GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
    @Enumerated(EnumType.STRING)
	@NotNull
	OperationType operationType;
	@NotNull
	private LocalDate date;
	@NotNull
	private LocalTime time;
	@NotNull
	private boolean paid;
	private String comment;
	private String tag;
	private String beneficiary;
	@NotNull
	private String owner;

}