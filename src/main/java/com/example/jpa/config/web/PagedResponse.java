package com.example.jpa.config.web;

import lombok.Getter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.List;

@Getter
public class PagedResponse<T> {
    int pageNumber;
    int pageSize;
    int totalElements;
    List<T> content;

    protected PagedResponse() {
    }

    public PagedResponse(Page<T> page) {
        this.pageNumber = page.getNumber();
        this.pageSize = page.getSize();
        this.content = page.getContent();
        this.totalElements = (int) page.getTotalElements();
    }

    protected PagedResponse(Pageable pageable) {
        pageNumber = pageable.getPageNumber();
        pageSize = pageable.getPageSize();
        content = Collections.emptyList();
        totalElements = 0;
    }

    public Integer getNextPageNumber() {
        if (totalElements > 0) {
            // TODO calculate
        }
        return null;
    }

    public static <T> PagedResponse<T> of(Page<T> page) {
        return new PagedResponse<>(page);
    }

    public static <T> PagedResponse<T> empty(Pageable pageable) {
        return new PagedResponse(pageable);
    }
}
