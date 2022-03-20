package self.learning.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import self.learning.service.GameService;
import self.learning.util.AttributeNames;
import self.learning.util.GameMappings;
import self.learning.util.ViewNames;

import javax.jws.WebParam;

@Slf4j
@Controller
public class GameController {

    // -- filed
    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    //-- request method

    @GetMapping(GameMappings.PLAY)
    public String play(Model model){
        model.addAttribute(AttributeNames.MAIN_MESSAGE, gameService.getMainMessage());
        model.addAttribute(AttributeNames.RESULT_MESSAGE, gameService.getResultMessage());

        log.info("Model : {}", model);

        if(gameService.isGameOver()) {
            return ViewNames.GAME_OVER;
        }
        return ViewNames.PLAY;
    }

    @PostMapping(GameMappings.PLAY)
    public String processMessage(@RequestParam int guess) {
        log.info("guess= {}", guess);
        gameService.checkGuess(guess);
        return GameMappings.REDIRECT_PLAY;
    }

    @GetMapping(GameMappings.RESTART)
    public String restart(){
    log.info("Game is reset : {}");
    gameService.reset();

    return GameMappings.REDIRECT_PLAY;
        }
}
