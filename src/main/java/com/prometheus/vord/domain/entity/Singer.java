package com.prometheus.vord.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "singer")
@NoArgsConstructor
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Singer {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", length = 40)
    private String name;

    @Column(name = "image", length = 600)
    private String image;
}
