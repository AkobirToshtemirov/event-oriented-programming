package com.akobir.eop.controller;

import com.akobir.eop.dto.BlogCreateDTO;
import com.akobir.eop.dto.BlogUpdateDTO;
import com.akobir.eop.entity.Blog;
import com.akobir.eop.service.BlogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogs")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable Long id) {
        Blog blog = blogService.getBlogById(id);
        return ResponseEntity.ok(blog);
    }

    @GetMapping
    public ResponseEntity<List<Blog>> getAllBlogs() {
        List<Blog> blogs = blogService.getAllBlogs();
        return ResponseEntity.ok(blogs);
    }

    @PostMapping
    public ResponseEntity<Blog> createBlog(@RequestBody @Valid BlogCreateDTO blogCreateDTO) {
        Blog savedBlog = blogService.createBlog(blogCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBlog);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable Long id, @RequestBody @Valid BlogUpdateDTO blogUpdateDTO) {
        Blog updatedBlog = blogService.updateBlog(id, blogUpdateDTO);
        return ResponseEntity.ok(updatedBlog);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlogById(@PathVariable Long id) {
        blogService.deleteBlogById(id);
        return ResponseEntity.noContent().build();
    }

}
