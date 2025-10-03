package service;

import model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proxy.CommentNotificationProxy;
import repository.CommentRepository;

/**
 * Annotazione stereotype che indica che questa è una classe business logic.
 * Permette di fornire un bean di questo tipo al contesto.
 */
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;

    /**
     * Iniettiamo le dipendenza di service tramite un costruttore annotato con autowired
     * @param commentRepository
     * @param commentNotificationProxy
     */
    @Autowired
    public CommentService(CommentRepository commentRepository, CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void publishComment(Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendNotification(comment);
    }
}
