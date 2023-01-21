package africa.semicolon.blogSystem.services;

import africa.semicolon.blogSystem.data.repositories.CommentRepository;
import africa.semicolon.blogSystem.dtos.requests.AddCommentRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CommentServiceImplTest {
    @Autowired
    CommentService commentService;

    @Autowired
    CommentRepository commentRepository;

    AddCommentRequest request;

    @BeforeEach
    void setUp() {
        request=new AddCommentRequest();
        request.setCommenter("Ade");
        request.setArticleTitle("Love and Lies");
        request.setContent("They say believe in love but interesting how lie sits right in the middle");
        request.setBlogName("Diary of Ade");
    }

    @Test
    void commentCanBeAddedToArticleTest() {
        assertNotNull(commentService.addComment(request).getId());

        assertEquals(1L, commentRepository.count());
        assertThat(commentRepository.count(), is(1L));

    }
}