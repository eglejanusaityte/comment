package com.comment.comment.business.repository;

import com.comment.comment.business.repository.model.Comment;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import reactor.core.publisher.Flux;

public interface CommentRepository extends ReactiveMongoRepository<Comment, String> {
    @Tailable
    Flux<Comment> findByCommentId(Integer commentId);
}