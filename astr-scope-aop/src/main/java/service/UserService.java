package service;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE) //A differenza di singleton (default) lo scope protype crea una istanza diversa dell'oggetto ogni volta che ne viene richiesto uno
public class UserService {
    void stampaIstanzaPrototype() {

    }
}
