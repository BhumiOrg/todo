package self.learning;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class MessageGeneratorImpl implements MessageGenerator {

    // == constants == Translation did not work during 1o Feb
    //private static final String MAIN_MESSAGE = "game.main.message";
    // == fields ==
    private final Game game;
   // private final MessageSource messageSource;
    // == constructor ==


    public MessageGeneratorImpl(Game game) {
        this.game = game;
       // this.messageSource = messageSource;
    }

    // == init ==
    @PostConstruct
    public void init() {
        log.info("game = {}", game);
    }
    // == public methods ==
    @Override
    public String getMainMessage() {

       //return getMessage(MAIN_MESSAGE, game.getSmallest(), game.getBiggest());
        return "Number is between " +
                game.getSmallest() +
                " and " +
                game.getBiggest() +
                ". Can you guess it?";
    }

    @Override
    public String getResultMessage() {

        if(game.isGameWon()) {
            return "You guessed it! The number was " + game.getNumber();
        } else if(game.isGameLost()) {
            return "You lost. The number was " + game.getNumber();
        } else if(!game.isValidNumberRange()) {
            return "Invalid number range!";
        } else if(game.getRemainingGuesses() == game.getGuessCount()) {
            return "What is your first guess?";
        } else {
            String direction = "Lower";

            if(game.getGuess() < game.getNumber()) {
                direction = "Higher";
            }

            return direction + "! You have " + game.getRemainingGuesses() + " guesses left";
        }
    }

    /*/ == private methods ==
    private String getMessage(String code, Object... args) {
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    } */
}
