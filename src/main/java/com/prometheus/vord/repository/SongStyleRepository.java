package com.prometheus.vord.repository;

import com.prometheus.vord.domain.entity.SongList;
import com.prometheus.vord.domain.entity.SongStyle;
import com.prometheus.vord.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SongStyleRepository extends JpaRepository<SongStyle, Long> {
    public List<SongStyle> findByUserId(User userId);
}
