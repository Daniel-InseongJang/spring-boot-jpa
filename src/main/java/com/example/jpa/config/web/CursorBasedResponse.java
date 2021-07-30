package com.example.jpa.config.web;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

@Getter
@AllArgsConstructor
public class CursorBasedResponse<T, C> {
    List<T> content;
    boolean hasMore;
    C nextCursor;
    Optional<Long> totalCount;

    public static <T, C> CursorBasedResponse<T, C> ofPage(CursorBasedPage<T, C> source) {
        return new CursorBasedResponse<>(
                source.getContent(),
                source.isHasMore(),
                source.getNextCursor().orElse(null),
                source.getTotalCount()
        );
    }

    public static <T, C> CursorBasedResponse<T, C> ofPage(Page page) {
        boolean hasMore = (page.getPageable().getPageNumber() + 1) < page.getTotalPages() ? true : false;
        return new CursorBasedResponse(
                page.getContent(),
                hasMore,
                page.getPageable().getPageNumber() + 1,
                Optional.of(page.getTotalElements())
        );
    }
}
