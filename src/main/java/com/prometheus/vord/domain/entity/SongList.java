package com.prometheus.vord.domain.entity;

import jakarta.persistence.*;
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

    @Column(name = "singer", length = 40)
    private String singer;

    @Column(name = "file_location", length = 200)
    private String fileLocation;

    @Column(name = "cover_image", length = 300)
    private String coverImage;

    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST
    )
    @JoinColumn(name = "user_id")
    private User userId;

}
