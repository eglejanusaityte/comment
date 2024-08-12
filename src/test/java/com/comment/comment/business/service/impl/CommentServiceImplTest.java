package com.comment.comment.business.service.impl;

import com.comment.comment.business.mappers.CommentMapper;
import com.comment.comment.business.repository.CommentRepository;
import com.comment.comment.business.repository.model.CommentDAO;
import com.comment.comment.model.Comment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

@ExtendWith(MockitoExtension.class)
class CommentServiceImplTest {

    @Mock
    private CommentRepository commentRepository;

    @Mock
    private CommentMapper commentMapper;

    @InjectMocks
    private CommentServiceImpl commentService;

    private CommentDAO commentDAO;
    private Comment comment;

    @BeforeEach
    void setUp() {
        commentDAO = new CommentDAO();
        commentDAO.setCommentId(1);
        commentDAO.setMessage("Test comment");
        commentDAO.setCreatedAt(LocalDateTime.now());

        comment = new Comment();
        comment.setCommentId(1);
        comment.setMessage("Test comment");
        comment.setCreatedAt(LocalDateTime.now());
    }


}