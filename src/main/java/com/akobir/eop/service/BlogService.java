package com.akobir.eop.service;

import com.akobir.eop.dto.BlogCreateDTO;
import com.akobir.eop.dto.BlogUpdateDTO;
import com.akobir.eop.entity.Blog;

import java.util.List;

public interface BlogService {
    Blog createBlog(BlogCreateDTO dto);

    Blog getBlogById(Long id);

    List<Blog> getAllBlogs();

    Blog updateBlog(Long id, BlogUpdateDTO dto);

    void deleteBlogById(Long id);
}
