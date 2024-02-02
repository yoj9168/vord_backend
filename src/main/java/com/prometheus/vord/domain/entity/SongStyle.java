package com.prometheus.vord.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Entity
@Table(name = "song_style")
@NoArgsConstructor
@Getter
@EntityListeners(AuditingEntityListener.class)
public class SongStyle {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "style", length = 40)
    private String style;

    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST
    )
    @JoinColumn(name = "user_id")
    private User userId;

    public void updateStyle(User user) {
        this.userId = user;
    }
}
