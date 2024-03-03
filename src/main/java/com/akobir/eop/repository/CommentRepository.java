package com.akobir.eop.repository;

import com.akobir.eop.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    void deleteByBlogId(Long blogId);

    List<Comment> findByBlogId(Long blogId);
}
