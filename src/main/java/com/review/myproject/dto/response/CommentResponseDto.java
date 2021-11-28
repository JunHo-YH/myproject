package com.review.myproject.dto.response;

import com.review.myproject.domain.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {

//    private String username;
    private String contents;
    private LocalDateTime lastModifiedDate;

    public CommentResponseDto(Comment comment) {
//        this.username = comment.getUser().getUsername();
        this.contents = comment.getContents();
        this.lastModifiedDate = comment.getLastModifiedDate();

    }
}
