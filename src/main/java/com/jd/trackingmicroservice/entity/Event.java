package com.jd.trackingmicroservice.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name ="Event")
@Data
public class Event {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@NotNull
	private LocalDateTime timestamp;
	@NotNull
	private LocalDate eventAt;
	private String eventType;
	@NotNull
	private String payload;
	@NotNull
	private UUID sessionId;

}
