package africa.semicolon.blogSystem.services;

import africa.semicolon.blogSystem.data.models.Comment;
import africa.semicolon.blogSystem.data.repositories.CommentRepository;
import africa.semicolon.blogSystem.dtos.requests.AddCommentRequest;
import africa.semicolon.blogSystem.dtos.responses.AddCommentResponse;
import africa.semicolon.blogSystem.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    CommentRepository commentRepository;

    @Override
    public void deleteComment(Comment comment) {
        commentRepository.delete(comment);
    }
    @Override
    public Comment addComment(AddCommentRequest request) {
        Comment comment = new Comment();
        Mapper.map(request, comment);


        return commentRepository.save(comment);
    }
}
