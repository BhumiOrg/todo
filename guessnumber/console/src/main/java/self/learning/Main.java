package self.learning;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import self.learning.config.GameConfig;

@Slf4j
@SpringBootApplication
public class Main {
   // private static final Logger log = LoggerFactory.getLogger(Main.class);

    //removed for Java Annotation configuration
    // private static final String CONFIG_LOCATION = "bean.xml";

    public static void main(String[] args) {
        log.info("Guess the number game");

        SpringApplication.run(Main.class, args);

        //creates context (container)
        // ConfigurableApplicationContext context= new ClassPathXmlApplicationContext(CONFIG_LOCATION);
        // Commenting during 77- Adding Spring boot to existing project
        //ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(GameConfig.class);
/*
        // get number generator bean from context (container)
        NumberGenerator numberGenerator
                = context.getBean(NumberGenerator.class);

        //call method next() to get a random number
        int number = numberGenerator.next();

        // log generated number
        log.info("number = {}", number);
        log.trace("number = {}", number);
        log.debug("number = {}", number);
        System.out.println(number);

        //get game bean from context (container)
        //Game game = context.getBean(Game.class);

        //get message generator bean from context (Container)
        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);
        log.info("getMainMessage = {}", messageGenerator.getMainMessage());
        log.info("getResultMessage = {}", messageGenerator.getResultMessage());

        //call reset method
        // deleted this to automatically initialize
        //game.reset();
*/
        //close context (container)

        // Commenting during 77- Adding Spring boot to existing project
        //context.close();
    }
}
