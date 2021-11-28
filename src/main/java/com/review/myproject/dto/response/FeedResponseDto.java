package com.review.myproject.dto.response;

import com.review.myproject.domain.Comment;
import com.review.myproject.domain.Feed;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class FeedResponseDto {
//    private final String username;
    private final String contents; // 피드 게시글
    private final List<CommentResponseDto> comments = new ArrayList<>(); // 피드에 달린 댓글
    private LocalDateTime lastModifiedDate;

    public FeedResponseDto(Feed feed) {
//        this.username = feed.getUser().getUsername();
        this.contents = feed.getContents();
        for (Comment comment : feed.getComments()) {
            CommentResponseDto commentResponseDto = new CommentResponseDto(comment);
            this.comments.add(commentResponseDto);
        }
        this.lastModifiedDate = feed.getLastModifiedDate();
    }
}
