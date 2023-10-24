package baseball.service;

import baseball.model.BallNumber;
import baseball.model.BaseballNumber;
import baseball.model.Result;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BallServiceTest {

    @Test
    public void randomNumTest() {
        BallService ballService = new BallService();

        BaseballNumber randomNum = ballService.generateRandomNum();
        assertNotNull(randomNum);
    }

    @Test
    public void userInputTest() {
        String userInput = "123";

        BallService ballService = new BallService();
        BaseballNumber userBaseballNumber = ballService.initUserNumber(userInput);

        Result result = userBaseballNumber.compare(new BaseballNumber(
                List.of(new BallNumber(1), new BallNumber(2), new BallNumber(3)))
        );

        assertEquals(result.getResult(), "3스트라이크");
    }
}