package com.prometheus.vord.domain.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "songs")
@NoArgsConstructor
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Song {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "singer", length = 40)
    private String singer;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "file_location", length = 200)
    private String fileLocation;

    @Column(name = "original_singer", length = 40)
    private String originalSinger;

    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST
    )
    @JoinColumn(name = "list_id")
    private SongList songList;

    @Builder
    public Song(String singer, String name, String fileLocation, String originalSinger, SongList songList){
        this.singer = singer;
        this.name = name;
        this.fileLocation = fileLocation;
        this.originalSinger = originalSinger;
        this.songList = songList;
    }

}
