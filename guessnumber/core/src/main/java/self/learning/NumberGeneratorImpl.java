package self.learning;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

//@Component("generator")
@Component
public class NumberGeneratorImpl implements NumberGenerator{
    // ==fields ==
    private final Random random = new Random();

    @Getter
    private final int maxNumber;

    @Getter
    private final int minNumber;

    // -- constructor--

    @Autowired
    public NumberGeneratorImpl(@MaxNumber int maxNumber, @MinNumber int minNumber) {
        this.maxNumber = maxNumber;
        this.minNumber = minNumber;
    }

    // public methods
    @Override
    //example : min=5 and max=20 -> max-min -> range 0-15 + min -> 5-20
    public int next() {
        return random.nextInt(maxNumber - minNumber) + minNumber;
    }

    /* Lombok invokes
    @Override
    public int getMaxNumber() {
        return maxNumber;
    }

    @Override
    public int getMinNumber(){
        return minNumber;
    }
*/

}
