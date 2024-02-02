package com.prometheus.vord.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "recommend_song")
@NoArgsConstructor
@Getter
@EntityListeners(AuditingEntityListener.class)
public class RecommendSong {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", length = 40)
    private String name;

    @Column(name = "singer", length = 30)
    private String singer;

    @Column(name = "type")
    private int type;

    @Column(name = "image")
    private byte[] image;
}
