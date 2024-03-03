package com.akobir.eop.listener;

import com.akobir.eop.event.UserCreatedEvent;
import com.akobir.eop.event.UserUpdatedEvent;
import com.akobir.eop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@Slf4j
@RequiredArgsConstructor
public class UserEventsListener {

    private final UserRepository userRepository;

    @Async
    @EventListener(UserCreatedEvent.class)
    public void handleUserCreateEvent(UserCreatedEvent event) {
        log.info("User Create Listener");
        event.getUser().setCreatedAt(Instant.now());
        userRepository.save(event.getUser());
    }

    @Async
    @EventListener(UserUpdatedEvent.class)
    public void handleUserUpdateEvent(UserUpdatedEvent event) {
        log.info("User Update Listener");
        event.getUser().setUpdatedAt(Instant.now());
        userRepository.save(event.getUser());
    }

}
