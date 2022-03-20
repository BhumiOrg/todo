package self.learning.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import self.learning.GuessCount;
import self.learning.MaxNumber;
import self.learning.MinNumber;

@Configuration
@ComponentScan(basePackages = "self.learning")
@PropertySource("classpath:config/game.properties")
public class GameConfig {

    // -- fields --
//    @Value("${game.maxNumber:20}") can be used when there is declaration in the properties file and default mentioned here will be used.
    @Value("${game.maxNumber:20}")
    private int maxNumber;

    @Value("${game.guessCount:5}")
    private int guessCount;

    @Value("${game.minNumber:5}")
    private int minNumber;


    // -- bean methods
    @Bean
    @MaxNumber
    public int maxNumber() {
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount() {
        return guessCount;
    }

    @Bean
    @MinNumber
    public int minNumber() {
        return minNumber;
    }
}
