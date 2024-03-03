package com.akobir.eop.listener;

import com.akobir.eop.event.BlogDeletedEvent;
import com.akobir.eop.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class BlogEventListener {
    private final CommentRepository commentRepository;

    @EventListener(BlogDeletedEvent.class)
    public void handleBlogDeleteEvent(BlogDeletedEvent event) {
        log.info("Blog Delete Event");
        Long blogId = event.getBlog().getId();
        commentRepository.deleteByBlogId(blogId);
    }
}
