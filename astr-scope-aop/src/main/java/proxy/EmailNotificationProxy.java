package proxy;

import model.Comment;
import org.springframework.stereotype.Component;

/**
 * Implementazione della interfaccia CommentNotificationProxy.
 * L'annotazione è per componenti generici poichè non ce n'è una specifica
 */
@Component
public class EmailNotificationProxy implements CommentNotificationProxy {
    @Override
    public void sendNotification(Comment comment) {
        System.out.println("- Invio email con il commento: " + comment.getText());
    }
}
