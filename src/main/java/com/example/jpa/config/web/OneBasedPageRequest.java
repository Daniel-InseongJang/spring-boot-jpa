package com.example.jpa.config.web;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PROTECTED)
public class OneBasedPageRequest {
    int page = 1;
    int size = 10;

    public Pageable toZeroBasedPageable() {
        if (page < 1) {
            throw new IllegalArgumentException("페이지 번호는 1이상이어야 합니다.");
        }

        if (size < 1) {
            throw new IllegalArgumentException("페이지 크기는 0보다 커야 합니다.");
        }

        return org.springframework.data.domain.PageRequest.of(page - 1, size);
    }

    public Pageable toZeroBasedPageableAndSorting(String sort) {
        if (page < 1) {
            throw new IllegalArgumentException("페이지 번호는 1이상이어야 합니다.");
        }

        if (size < 1) {
            throw new IllegalArgumentException("페이지 크기는 0보다 커야 합니다.");
        }

        return org.springframework.data.domain.PageRequest.of(page - 1, size, Sort.by(sort));
    }
}
