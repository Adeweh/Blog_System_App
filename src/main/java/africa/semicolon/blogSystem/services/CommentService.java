package africa.semicolon.blogSystem.services;

import africa.semicolon.blogSystem.data.models.Comment;
import africa.semicolon.blogSystem.dtos.requests.AddCommentRequest;


public interface CommentService {
    void deleteComment(Comment comment);

    Comment addComment(AddCommentRequest request);
}
