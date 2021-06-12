package tirwanda.edho.database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tirwanda.edho.database.entity.Comment;
import tirwanda.edho.database.repository.CommentRepository;
import tirwanda.edho.database.repository.CommentRepositoryImpl;

import java.util.List;

public class RepositoryTest {
    private CommentRepository commentRepository;

    @BeforeEach
    void setUp() {
        commentRepository = new CommentRepositoryImpl();
    }

    @Test
    void testInsert() {
        Comment comment = new Comment("edho@gmail.com", "Hello my name is Edho");
        commentRepository.insert(comment);

        Assertions.assertNotNull(comment.getId());
    }

    @Test
    void testFindById() {
        Comment comment = commentRepository.findById(1302);
        Assertions.assertNotNull(comment);

        System.out.println(comment.getId());
        System.out.println(comment.getEmail());
        System.out.println(comment.getComment());

        Comment notFound = commentRepository.findById(999);
        Assertions.assertNull(notFound);
    }

    @Test
    void testFindAll() {
        List<Comment> comments = commentRepository.findAll();
        System.out.println(comments.size());
    }

    @Test
    void testFindAllByEmail() {
        List<Comment> comments = commentRepository.findAllByEmail("edho@gmail.com");
        Assertions.assertNotNull(comments);
    }
}
