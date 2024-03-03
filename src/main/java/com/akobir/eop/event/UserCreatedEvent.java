package com.akobir.eop.event;

import com.akobir.eop.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserCreatedEvent {
    private User user;
}
