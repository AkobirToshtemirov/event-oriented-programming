package com.akobir.eop.mapper;

import com.akobir.eop.dto.CommentCreateDTO;
import com.akobir.eop.dto.CommentUpdateDTO;
import com.akobir.eop.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    @Mapping(target = "id", ignore = true)
    Comment commentCreateDtoToEntity(CommentCreateDTO dto);

    void updateCommentFromDto(CommentUpdateDTO dto, @MappingTarget Comment comment);

    CommentCreateDTO commentToCreateDto(Comment comment);

    CommentUpdateDTO commentToUpdateDto(Comment comment);
}
