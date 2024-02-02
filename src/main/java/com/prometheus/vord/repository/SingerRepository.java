package com.prometheus.vord.repository;

import com.prometheus.vord.domain.entity.Singer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SingerRepository extends JpaRepository<Singer, Long> {
}
