package com.comment.comment.web.controller;

import com.comment.comment.business.repository.CommentRepository;
import com.comment.comment.business.repository.model.Comment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.LocalDateTime;

@RestController
public class CommentController {
    private final CommentRepository commentRepository;

    public CommentController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/comment/id/{commentId}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Comment> getMessages(@PathVariable Integer commentId) {
        return commentRepository.findByCommentId(commentId)
                .subscribeOn(Schedulers.boundedElastic())
                .doOnError(error -> System.err.println("Error occurred: " + error.getMessage()));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/comment")
    public Mono<Comment> newMessage(@RequestBody Comment comment) {
        comment.setCreatedAt(LocalDateTime.now());
        return commentRepository.save(comment);
    }
}
