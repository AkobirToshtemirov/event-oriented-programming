package com.akobir.eop.service.impl;

import com.akobir.eop.dto.BlogCreateDTO;
import com.akobir.eop.dto.BlogUpdateDTO;
import com.akobir.eop.entity.Blog;
import com.akobir.eop.entity.User;
import com.akobir.eop.event.BlogDeletedEvent;
import com.akobir.eop.exception.NotFoundException;
import com.akobir.eop.mapper.BlogMapper;
import com.akobir.eop.repository.BlogRepository;
import com.akobir.eop.repository.UserRepository;
import com.akobir.eop.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;
    private final BlogMapper blogMapper;
    private final ApplicationEventPublisher eventPublisher;
    private final UserRepository userRepository;

    @Override
    public Blog createBlog(BlogCreateDTO dto) {
        Blog blog = blogMapper.blogCreateDtoToEntity(dto);
        User user = userRepository.findById(dto.userId())
                .orElseThrow(() -> new NotFoundException("User not found with id: " + dto.userId()));
        blog.setUser(user);
        return blogRepository.save(blog);
    }

    @Override
    public Blog getBlogById(Long id) {
        return blogRepository.findById(id).orElseThrow(() -> new NotFoundException("Blog not found with id: " + id));
    }

    @Override
    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    @Override
    public Blog updateBlog(Long id, BlogUpdateDTO dto) {
        Blog blog = blogRepository.findById(id).orElseThrow(() -> new NotFoundException("Blog not found with id: " + id));
        blogMapper.updateBlogFromDto(dto, blog);
        return blogRepository.save(blog);
    }

    @Override
    @Transactional
    public void deleteBlogById(Long id) {
        Blog blog = blogRepository.findById(id).orElseThrow(() -> new NotFoundException("Blog not found with id: " + id));
        eventPublisher.publishEvent(new BlogDeletedEvent(blog));
        blogRepository.deleteById(id);
    }

}
