package com.review.myproject.service;

import com.review.myproject.domain.Feed;
import com.review.myproject.dto.request.FeedRequestDto;
import com.review.myproject.dto.response.FeedResponseDto;
import com.review.myproject.repository.FeedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FeedService {

    private final FeedRepository feedRepository;

    // 피드 조회
    public List<FeedResponseDto> getFeeds() {
        return feedRepository.findAll()
                .stream()
                .map(FeedResponseDto::new)
                .collect(Collectors.toList());
    }

    // 피드 생성
    public void createFeed(FeedRequestDto feedRequestDto) {
        Feed feed = new Feed(feedRequestDto);
        feedRepository.save(feed);
    }

    // 피드 수정
    @Transactional
    public void updateFeed(Long feedId, FeedRequestDto feedRequestDto) {
        Feed feed = feedRepository.findById(feedId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 피드입니다.")
        );
        feed.updateFeed(feedRequestDto);
    }

    // 피드 삭제
    public void deleteFeed(Long feedId) {
        feedRepository.findById(feedId);
    }

}
