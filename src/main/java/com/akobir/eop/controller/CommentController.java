package com.akobir.eop.controller;

import com.akobir.eop.dto.CommentCreateDTO;
import com.akobir.eop.dto.CommentUpdateDTO;
import com.akobir.eop.entity.Comment;
import com.akobir.eop.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Long id) {
        Comment comment = commentService.getCommentById(id);
        return ResponseEntity.ok(comment);
    }

    @PostMapping
    public ResponseEntity<Comment> createComment(@RequestBody @Valid CommentCreateDTO commentCreateDTO) {
        Comment savedComment = commentService.createComment(commentCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedComment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long id, @RequestBody @Valid CommentUpdateDTO commentUpdateDTO) {
        Comment updatedComment = commentService.updateComment(id, commentUpdateDTO);
        return ResponseEntity.ok(updatedComment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommentById(@PathVariable Long id) {
        commentService.deleteCommentById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/blog/{blogId}")
    public ResponseEntity<List<Comment>> getCommentsByBlogId(@PathVariable Long blogId) {
        List<Comment> comments = commentService.getCommentsByBlogId(blogId);
        return ResponseEntity.ok(comments);
    }
}
