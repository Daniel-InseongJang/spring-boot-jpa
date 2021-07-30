package com.example.jpa.config.web;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PROTECTED)
public class CursorBasedRequest {
    String cursor = "";
    int size = 10;

    public Pageable toZeroBasedPageable() {
        if (size < 1) {
            throw new IllegalArgumentException("페이지 크기는 0보다 커야 합니다.");
        }

        return PageRequest.of(0, size);
    }
}
