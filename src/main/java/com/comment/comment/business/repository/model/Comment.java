package com.comment.comment.business.repository.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Document(collection = "chat")
public class Comment {
    @Id
    private String id;
    private String message;
    private String sender;
    private String receiver;
    private Integer commentId;
    private LocalDateTime createdAt;
}
