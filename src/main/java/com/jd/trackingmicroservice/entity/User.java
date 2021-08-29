package com.jd.trackingmicroservice.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="AppUser")
@NoArgsConstructor
@Data
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private UUID userId;
	private UUID machineId;
	private UUID orgId;
	@NotNull
	private UUID sessionId;
	@NotNull
	private LocalDateTime startAt;
	private LocalDateTime endAt;

}
