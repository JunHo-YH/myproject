package com.review.myproject.service;

import com.review.myproject.domain.Comment;
import com.review.myproject.domain.Feed;
import com.review.myproject.dto.request.CommentRequestDto;
import com.review.myproject.dto.response.CommentResponseDto;
import com.review.myproject.repository.CommentRepository;
import com.review.myproject.repository.FeedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final FeedRepository feedRepository;

    public List<CommentResponseDto> getComments(Long feedId) {
        // 해당 피드에 대한 댓글을 찾기 위해 어떤 피드인지 먼저 조회힌다.
        Feed feed = feedRepository.findById(feedId).orElseThrow(
                () -> new IllegalArgumentException("존재하는 피드가 없습니다.")
        );

        // 해당 피드의 댓글을 Dto에 담아서 반환
        return feed.getComments()
                .stream()
                .map(CommentResponseDto::new)
                .collect(Collectors.toList());

    }

    // 댓글 생성
    public void createComment(Long feedId, CommentRequestDto commentRequestDto) {
        // 피드를 찾는다.
        Feed feed = feedRepository.findById(feedId).orElseThrow(
                () -> new IllegalArgumentException("해당 피드가 존재하지 않습니다.")
        );
        // 댓글을 생성할 피드 정보를 Comment 객체에 전달한다.
        Comment comment = new Comment(feed, commentRequestDto);
        commentRepository.save(comment);
    }

    // 댓글 수정
    @Transactional
    public void updateComment(Long commentId, CommentRequestDto commentRequestDto) {
        // 해당 댓글의 객체를 찾는다.
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 댓글입니다.")
        );

        // 해당 댓글의 객체에서 댓글을 수정한다.
        comment.updateComment(commentRequestDto);
    }

    // 댓글 삭제
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }


}
