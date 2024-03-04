package com.akobir.eop.service.impl;

import com.akobir.eop.dto.CommentCreateDTO;
import com.akobir.eop.dto.CommentUpdateDTO;
import com.akobir.eop.entity.Blog;
import com.akobir.eop.entity.Comment;
import com.akobir.eop.entity.User;
import com.akobir.eop.exception.NotFoundException;
import com.akobir.eop.mapper.CommentMapper;
import com.akobir.eop.repository.BlogRepository;
import com.akobir.eop.repository.CommentRepository;
import com.akobir.eop.repository.UserRepository;
import com.akobir.eop.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
    private final UserRepository userRepository;
    private final BlogRepository blogRepository;

    @Override
    public Comment createComment(CommentCreateDTO dto) {
        Comment comment = commentMapper.commentCreateDtoToEntity(dto);
        User user = userRepository.findById(dto.userId())
                .orElseThrow(() -> new NotFoundException("User not found with id: " + dto.userId()));
        Blog blog = blogRepository.findById(dto.blogId())
                .orElseThrow(() -> new NotFoundException("Blog not found with id: " + dto.blogId()));

        comment.setUser(user);
        comment.setBlog(blog);

        return commentRepository.save(comment);
    }

    @Override
    public Comment getCommentById(Long id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Comment not found with id: " + id));
    }

    @Override
    public Comment updateComment(Long id, CommentUpdateDTO dto) {
        Comment existingComment = getCommentById(id);
        commentMapper.updateCommentFromDto(dto, existingComment);
        return commentRepository.save(existingComment);
    }

    @Override
    public void deleteCommentById(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public List<Comment> getCommentsByBlogId(Long blogId) {
        return commentRepository.findByBlogId(blogId);
    }

}
