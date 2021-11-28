package com.review.myproject.dto.request;

import lombok.Getter;

@Getter
public class CommentRequestDto {

    private String contents;

    // 생성, 수정 날짜는 Auditing에서 자동으로 주입한다.
}

