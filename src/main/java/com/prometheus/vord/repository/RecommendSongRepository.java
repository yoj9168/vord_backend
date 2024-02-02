package com.prometheus.vord.repository;

import com.prometheus.vord.DTO.ResponsePlaylistSituation;
import com.prometheus.vord.domain.entity.RecommendSong;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecommendSongRepository extends JpaRepository<RecommendSong, Long> {
    public List<RecommendSong> findByType(int type);
}
