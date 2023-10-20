package baseball.model;

import java.util.List;
import org.junit.jupiter.api.Test;


public class ComputerNumberTest {
    List<Integer> randomNumber = ComputerNumber.makeComputerNumber();

    @Test
    void randomDataTest() {
        System.out.println(randomNumber);
    }
}
