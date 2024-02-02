package com.prometheus.vord.repository;

import com.prometheus.vord.domain.entity.Song;
import com.prometheus.vord.domain.entity.SongList;
import com.prometheus.vord.domain.entity.SongStyle;
import com.prometheus.vord.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long> {
    public List<Song> findBySongList(SongList songList);

}
