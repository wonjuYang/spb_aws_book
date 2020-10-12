package com.wonju.www.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter //선언된 모든 필드의 get 메소드를 생성해 줍니다.
@RequiredArgsConstructor // 선언된 모든 final 필드가 포함된 생성자를 생성해 줍니다.
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
