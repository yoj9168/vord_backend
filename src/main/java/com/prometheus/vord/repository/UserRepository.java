package com.prometheus.vord.repository;

import com.prometheus.vord.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
