package com.comment.comment.business.mappers;

import com.comment.comment.business.repository.model.CommentDAO;
import com.comment.comment.model.Comment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    CommentDAO commentToCommentDAO(Comment comment);
    Comment commentDAOToComment(CommentDAO commentDAO);

}
