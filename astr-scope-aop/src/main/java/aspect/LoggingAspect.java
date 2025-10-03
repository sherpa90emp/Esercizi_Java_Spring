package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect // contrassegna la classe come un aspect fornendo le sue funzionalità
@Component // vogliamo un bean nel context
public class LoggingAspect {
    // un oggetto di java che permette di loggare in console
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    // Il metodo che intercetta gli altri metodi.
    // Tramite @Around possiamo svolgere operazioni prima dopo e durante l'esecuzione dei metodi intercettati
    //l'espressione dentro l'annotazione è un Pointcut che definisce QUALI metodi intercettare
    //execution = all'esecuzione dei metodi * = che tornano qualsiasi tipo di dato (se specifico es: int intercetterà solo i metodi con int) org.example.service = in questo package .* = tutte le classi .* = tutti i metodi (..) = accettano qualsiasi tipo di input
    @Around("execution(* service.*.*(..)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        //eseguo logica prima dell'esecuzione del metodo
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        logger.info("AOP - Metodo " + methodName + " chiamato con parametri " + Arrays.asList(args));
        Object retByMethod = joinPoint.proceed(); // eseguo il metodo originale
        //eseguo logica dopo l'esecuzione del metodo
        logger.warning("AOP - Metodo eseguito, ha restituito " + retByMethod);
        return retByMethod; //ritorniamo l'oggetto che avrebbe ritornato il metodo originale
    }
}
