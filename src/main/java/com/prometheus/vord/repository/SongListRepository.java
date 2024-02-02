package com.prometheus.vord.repository;

import com.prometheus.vord.domain.entity.Song;
import com.prometheus.vord.domain.entity.SongList;
import com.prometheus.vord.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SongListRepository extends JpaRepository<SongList, Long> {
    public List<SongList> findByUserId(User userId);
}
