package com.jd.trackingmicroservice.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jd.trackingmicroservice.entity.User;

public interface UserRepository extends JpaRepository<User, UUID>  {

	User findBySessionId(UUID sessiondId);
}
