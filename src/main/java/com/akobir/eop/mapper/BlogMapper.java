package com.akobir.eop.mapper;

import com.akobir.eop.dto.BlogCreateDTO;
import com.akobir.eop.dto.BlogUpdateDTO;
import com.akobir.eop.entity.Blog;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BlogMapper {

    @Mapping(target = "id", ignore = true)
    Blog blogCreateDtoToEntity(BlogCreateDTO dto);

    @Mapping(target = "id", ignore = true)
    void updateBlogFromDto(BlogUpdateDTO dto, @MappingTarget Blog blog);

}
