package baseball.service;

import baseball.model.Ball;
import baseball.model.BallNumbers;
import baseball.model.Result;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BallServiceTest {

    @Test
    public void randomNumTest() {
        BallService ballService = new BallService();

        BallNumbers randomBallNumbers = ballService.generateRandomBallNumbers();
        assertNotNull(randomBallNumbers);
    }

    @Test
    public void userInputTest() {
        String userInput = "123";

        BallService ballService = new BallService();
        BallNumbers userBallNumbers = ballService.initUserBallNumbers(userInput);

        Result result = userBallNumbers.compare(new BallNumbers(
                List.of(new Ball(1), new Ball(2), new Ball(3)))
        );

        assertEquals(result.getResult(), "3스트라이크");
    }
}