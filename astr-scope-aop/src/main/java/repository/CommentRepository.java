package repository;

import model.Comment;

/**
 * Astrazione per il repository dei commenti. Definisce cosa deve essere fatto, ovvero salvare un documento; Non specifica il come.
 */
public interface CommentRepository {
    void storeComment(Comment comment);
}
