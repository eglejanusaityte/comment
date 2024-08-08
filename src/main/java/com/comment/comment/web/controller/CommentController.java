package com.comment.comment.web.controller;

import com.comment.comment.model.Comment;
import com.comment.comment.business.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/comment/{commentId}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Comment> getComments(@PathVariable Integer commentId) {
        return commentService.getComments(commentId);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/comment")
    public ResponseEntity<Void> sendComment(@RequestBody Comment comment) {
        commentService.sendComment(comment);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
