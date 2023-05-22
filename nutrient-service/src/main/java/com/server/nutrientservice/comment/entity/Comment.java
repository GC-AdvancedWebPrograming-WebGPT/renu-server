package com.server.nutrientservice.comment.entity;

import com.server.nutrientservice.common.entity.BaseEntity;
import com.server.nutrientservice.nutrient.entity.Nutrient;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    private String content;

    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="nutrient_id")
    private Nutrient nutrient;
}
