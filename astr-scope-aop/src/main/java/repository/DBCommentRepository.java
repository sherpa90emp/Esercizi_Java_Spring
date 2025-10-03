package repository;

import model.Comment;
import org.springframework.stereotype.Repository;

/**
 * Classe DbCommentRepository implementa l'interfaccia CommentRepository.
 * @Repository indica a spring che questo è un repository e un bean di questo tipo verrà registrato nel context
 */
@Repository
public class DBCommentRepository implements CommentRepository {
    @Override
    public void storeComment(Comment comment) {
        System.out.println("> Salvataggio del commento: " + comment.getText() + " su Db");
    }
}
