package com.review.myproject.api;

import com.review.myproject.dto.request.CommentRequestDto;
import com.review.myproject.dto.response.CommentResponseDto;
import com.review.myproject.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/feeds/{feedId}/comments")
@RequiredArgsConstructor
@RestController
public class CommentApiController {

    private final CommentService commentService;

    // 댓글 조회
    @GetMapping
    public List<CommentResponseDto> getComments(@PathVariable Long feedId) {
        return commentService.getComments(feedId);
    }

    // 댓글 등록
    // 해당 피드에 댓글 리스트 등록
    @PostMapping
    public String createComment(@PathVariable Long feedId, @RequestBody CommentRequestDto commentRequestDto) {
        commentService.createComment(feedId, commentRequestDto);
        return "ok";
    }

    // 댓글 수정
    @PutMapping("/{commentId}")
    public String updateComment(@PathVariable Long commentId, @RequestBody CommentRequestDto commentRequestDto) {
        commentService.updateComment(commentId, commentRequestDto);
        return "ok";
    }

    // 댓글 삭제
    @DeleteMapping("/{commentId}")
    public String deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return "ok";
    }
}
