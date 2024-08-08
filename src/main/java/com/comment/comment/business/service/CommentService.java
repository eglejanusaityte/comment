package com.comment.comment.business.service;

import com.comment.comment.model.Comment;
import reactor.core.publisher.Flux;

public interface CommentService {
    Flux<Comment> getComments(Integer commentId);

    void sendComment(Comment comment);

}
