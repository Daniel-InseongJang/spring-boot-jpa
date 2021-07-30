package com.example.jpa.config.web;

import lombok.Getter;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
public class CursorBasedPage<T, C> {
    final List<T> content;
    final boolean hasMore;
    final Optional<C> nextCursor;
    final Optional<Long> totalCount;

    public CursorBasedPage(List<T> content, boolean hasMore, Optional<C> nextCursor, Optional<Long> totalCount) {
        this.content = Objects.requireNonNull(content, "content");
        this.hasMore = hasMore;
        this.nextCursor = nextCursor;
        this.totalCount = totalCount;
    }

    public <R> CursorBasedPage<R, C> map(Function<? super T, ? extends R> contentMapper) {
        return map(contentMapper, Function.identity());
    }

    public <TR, CR> CursorBasedPage<TR, CR> map(Function<? super T, ? extends TR> contentMapper,
                                                Function<? super C, ? extends CR> cursorMapper) {
        return new CursorBasedPage<>(
                content.stream().map(contentMapper).collect(Collectors.toList())
                , hasMore
                , nextCursor.map(cursorMapper)
                , totalCount
        );
    }
}
