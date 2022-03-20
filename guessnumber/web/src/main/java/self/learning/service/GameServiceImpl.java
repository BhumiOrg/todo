package self.learning.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import self.learning.Game;
import self.learning.MessageGenerator;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GameServiceImpl implements GameService {


    private final Game game;
    private final MessageGenerator messageGenerator;

    @Autowired
    public GameServiceImpl(Game game, MessageGenerator messageGenerator) {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }

    @PostConstruct
    public void init(){
        log.info("Number : {}", game.getNumber());
        log.info("My message : {}", messageGenerator.getMainMessage());
    }

    @Override
    public boolean isGameOver() {
        return game.isGameLost() || game.isGameWon();
    }

    @Override

    public String getMainMessage() {
        return messageGenerator.getMainMessage();
    }

    @Override
    public String getResultMessage() {
        return messageGenerator.getResultMessage();
    }

    @Override
    public void checkGuess(int guess) {
    game.setGuess(guess);
    game.check();
    }

    @Override
    public void reset() {
        game.reset();

    }
}
