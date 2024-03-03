package com.akobir.eop.mapper;

import com.akobir.eop.dto.UserRequestDTO;
import com.akobir.eop.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserRequestDTO dto);
}
