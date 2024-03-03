package com.akobir.eop.service;

import com.akobir.eop.dto.CommentCreateDTO;
import com.akobir.eop.dto.CommentUpdateDTO;
import com.akobir.eop.entity.Comment;

import java.util.List;

public interface CommentService {
    Comment createComment(CommentCreateDTO dto);

    Comment getCommentById(Long id);

    Comment updateComment(Long id, CommentUpdateDTO dto);

    void deleteCommentById(Long id);

    List<Comment> getCommentsByBlogId(Long blogId);
}
