package com.comment.comment.business.service.impl;

import com.comment.comment.business.mappers.CommentMapper;
import com.comment.comment.business.repository.CommentRepository;
import com.comment.comment.business.repository.model.CommentDAO;
import com.comment.comment.model.Comment;
import com.comment.comment.business.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.LocalDateTime;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    private final CommentMapper commentMapper;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }

    @Override
    public Flux<Comment> getComments(Integer commentId) {
        return commentRepository.findByCommentId(commentId)
                .map(commentMapper::commentDAOToComment)
                .subscribeOn(Schedulers.boundedElastic())
                .doOnError(error -> System.err.println("Error occurred: " + error.getMessage()));
    }

    @Override
    public void sendComment(Comment comment) {
        comment.setCreatedAt(LocalDateTime.now());
        CommentDAO commentDAO = commentMapper.commentToCommentDAO(comment);
        commentRepository.save(commentDAO).subscribe();
    }

}
