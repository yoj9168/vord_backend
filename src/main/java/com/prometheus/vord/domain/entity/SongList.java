package com.prometheus.vord.domain.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "song_list")
@NoArgsConstructor
@Getter
@EntityListeners(AuditingEntityListener.class)
public class SongList {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", length = 40)
    private String name;

    @Column(name = "cover_image", length = 700)
    private String coverImage;

    @Column(name = "type")
    private int type;

    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST
    )
    @JoinColumn(name = "user_id")
    private User userId;

    @Builder
    public SongList(String name,int type, String coverImage, User userId){
        this.name = name;
        this.type = type;
        this.coverImage = coverImage;
        this.userId = userId;
    }

    public void updateImage(String imageUrl) {
        this.coverImage = imageUrl;
    }
}
