package com.comment.comment.business.repository;

import com.comment.comment.business.repository.model.CommentDAO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import reactor.core.publisher.Flux;

public interface CommentRepository extends ReactiveMongoRepository<CommentDAO, String> {
    @Tailable
    Flux<CommentDAO> findByCommentId(Integer commentId);
}