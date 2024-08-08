package com.comment.comment.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Schema(description = "Model of comment")
@Getter
@Setter
public class Comment {

    @Id
    @Schema(description = "The unique id of the comment object", example = "669f62c534edd1440fb1ded6")
    private String id;

    @Schema(description = "The message of the comment", example = "Text example")
    private String message;

    @Schema(description = "The sender of comment username", example = "SenderUsername")
    private String sender;

    @Schema(description = "The receiver of comment username or 'All' to answer to all", example = "All")
    private String receiver;

    @Schema(description = "The unique id of the comment", example = "1")
    private Integer commentId;

    @Schema(description = "The time when comment was sent", example = "2024-07-23T07:59:01.479+00:00")
    private LocalDateTime createdAt;
}
