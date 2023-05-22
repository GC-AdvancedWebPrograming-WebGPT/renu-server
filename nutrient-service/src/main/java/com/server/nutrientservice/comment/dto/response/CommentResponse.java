package com.server.nutrientservice.comment.dto.response;

import com.server.nutrientservice.comment.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentResponse {

    private Long commentId;

    private String content;

    private Long userId;

    public static CommentResponse from(Comment comment){
        return CommentResponse.builder()
                .commentId(comment.getId())
                .content(comment.getContent())
                .userId(comment.getUserId())
                .build();
    }
}
