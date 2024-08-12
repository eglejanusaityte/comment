package com.comment.comment.web.controller;

import com.comment.comment.business.handler.CustomErrorResponse;
import com.comment.comment.model.Comment;
import com.comment.comment.business.service.CommentService;
import com.comment.comment.swagger.DescriptionVariables;
import com.comment.comment.swagger.HTMLResponseMessages;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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

@Tag(name = DescriptionVariables.COMMENT)
@RestController
@ApiResponses(value = {@ApiResponse(responseCode = "500", description = HTMLResponseMessages.HTTP_500, content = @Content), @ApiResponse(responseCode = "400", description = HTMLResponseMessages.HTTP_400, content = @Content(schema = @Schema(implementation = CustomErrorResponse.class))), @ApiResponse(responseCode = "404", description = HTMLResponseMessages.HTTP_404, content = @Content(schema = @Schema(implementation = CustomErrorResponse.class))),})
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/comment/{commentId}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @Operation(summary = "Gets all comments", description = "Gets all comments of specified post")
    public Flux<Comment> getComments(@PathVariable Integer commentId) {
        return commentService.getComments(commentId);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/comment")
    @Operation(summary = "Sends user comment", description = "Adds comment to list of comments and updates connected users")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = HTMLResponseMessages.HTTP_200)})
    public ResponseEntity<Void> sendComment(@RequestBody Comment comment) {
        commentService.sendComment(comment);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
