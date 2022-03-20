package self.learning.console;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import self.learning.Game;
import self.learning.MessageGenerator;

import java.util.Scanner;

@Slf4j
@Component
//public class ConsoleNumberGuess implements ApplicationListener<ContextRefreshedEvent>
public class ConsoleNumberGuess {
   // Logger log = LoggerFactory.getLogger(ConsoleNumberGuess.class);

    // -- fields --
    private final Game game;

    private final MessageGenerator messageGenerator;

    //---constructor --


    public ConsoleNumberGuess(Game game, MessageGenerator messageGenerator) {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }

    //-- events--
    /*@Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.info("Container ready to use"); */
    @EventListener(ContextRefreshedEvent.class)
    public void start(){
        log.info("Start --> Container is ready for use");
        log.debug("I am in debug: Container ready for use");
        log.trace("I am in trace: Container ready for use");

        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());

            int guess = scanner.nextInt();
            scanner.nextLine();
            game.setGuess(guess);
            game.check();

            if(game.isGameWon() || game.isGameLost()){
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("Play again : Y/N ?");

                String playAgainString = scanner.nextLine().trim();
                if(!playAgainString.equalsIgnoreCase("y")){
                    break;
                }
                game.reset();
            }
        }

    }
}
