package com.review.myproject.domain;

import com.review.myproject.dto.request.CommentRequestDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Comment extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "comment_id")
    private Long id;

    private String contents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id")
    private Feed feed; // 댓글이 어디 피드에 달렸는지 알아야 하니까.

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    // 댓글 생성
    public Comment(Feed feed, CommentRequestDto commentRequestDto) {
        this.feed = feed; // 댓글을 등록할 위치, 즉 피드의 정보를 전달한다.
        this.contents = commentRequestDto.getContents();

    }

    // 댓글 수정
    public void updateComment(CommentRequestDto commentRequestDto) {
        this.contents = commentRequestDto.getContents();
    }

}
