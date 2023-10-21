package baseball.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

public class ComputerTest {

    @Test
    void Computer_랜덤숫자생성() {
        Computer computer = new Computer();

        List<Integer> randomNumbers =  computer.getRandomNumbers();
        int createdResultSize = randomNumbers.size();

        Assertions.assertEquals(3, createdResultSize);
    }

    @Test
    void Computer_서로다른_랜덤숫자생성() {
        Computer computer = new Computer();
        List<Integer> randomNumbers =  computer.getRandomNumbers();

        HashSet<Integer> randomNumbersSet = new HashSet<>(randomNumbers);
        int createdResultSize = randomNumbersSet.size();

        Assertions.assertEquals(3, createdResultSize);
    }
}
