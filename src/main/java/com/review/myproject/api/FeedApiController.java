package com.review.myproject.api;

import com.review.myproject.dto.request.FeedRequestDto;
import com.review.myproject.dto.response.FeedResponseDto;
import com.review.myproject.service.FeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/feeds")
@RequiredArgsConstructor
@RestController
public class FeedApiController {

    private final FeedService feedService;

    // 피드 조회
    @GetMapping
    public List<FeedResponseDto> readFeeds() {
        System.out.println(feedService.getFeeds());
        return feedService.getFeeds();
    }

    // 피드 생성
    @PostMapping
    public String createFeed(@RequestBody FeedRequestDto feedRequestDto) {
        System.out.println(feedRequestDto);
        feedService.createFeed(feedRequestDto);
        return "ok";
    }

    // 피드 수정
    @PutMapping("/{feedId}")
    public String updateFeed(@PathVariable Long feedId, @RequestBody FeedRequestDto feedRequestDto) {
        System.out.println(feedId);
        feedService.updateFeed(feedId, feedRequestDto);
        return "ok";
    }

    // 피드 삭제
    @DeleteMapping("/{feedId}")
    public String deleteFeed(@PathVariable Long feedId) {
        feedService.deleteFeed(feedId);
        return "ok";
    }
}
