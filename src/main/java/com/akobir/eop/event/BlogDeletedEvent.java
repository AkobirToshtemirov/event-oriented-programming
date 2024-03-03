package com.akobir.eop.event;

import com.akobir.eop.entity.Blog;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BlogDeletedEvent {
    private Blog blog;
}
