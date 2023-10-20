package baseball.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RefereeTest {

    private Referee referee = new Referee();

    @Test
    public void 제로_스트라이크_테스트() {
        //given
        String randomNumbers = "123";
        String inputNumbers = "456";

        //when
        int strikeNumbers = referee.calculateStrikeNumbers(randomNumbers, inputNumbers);

        //then
        Assertions.assertEquals(strikeNumbers, 0);
    }

    @Test
    public void 원_스트라이크_테스트() {
        //given
        String randomNumbers = "123";
        String inputNumbers = "132";

        //when
        int strikeNumbers = referee.calculateStrikeNumbers(randomNumbers, inputNumbers);

        //then
        Assertions.assertEquals(strikeNumbers, 1);
    }

    @Test
    public void 투_스트라이크_테스트() {
        //given
        String randomNumbers = "123";
        String inputNumbers = "125";

        //when
        int strikeNumbers = referee.calculateStrikeNumbers(randomNumbers, inputNumbers);

        //then
        Assertions.assertEquals(strikeNumbers, 2);
    }

    @Test
    public void 쓰리_스트라이크_테스트() {
        //given
        String randomNumbers = "123";
        String inputNumbers = "123";

        //when
        int strikeNumbers = referee.calculateStrikeNumbers(randomNumbers, inputNumbers);

        //then
        Assertions.assertEquals(strikeNumbers, 3);
    }

    @Test
    public void 제로_볼_테스트() {
        //given
        String randomNumbers = "123";
        String inputNumbers = "456";

        //when
        int ballNumbers = referee.calculateBallNumbers(randomNumbers, inputNumbers);

        //then
        Assertions.assertEquals(ballNumbers, 0);
    }

    @Test
    public void 원_볼_테스트() {
        //given
        String randomNumbers = "123";
        String inputNumbers = "634";

        //when
        int ballNumbers = referee.calculateBallNumbers(randomNumbers, inputNumbers);

        //then
        Assertions.assertEquals(ballNumbers, 1);
    }

    @Test
    public void 투_볼_테스트() {
        //given
        String randomNumbers = "123";
        String inputNumbers = "632";

        //when
        int ballNumbers = referee.calculateBallNumbers(randomNumbers, inputNumbers);

        //then
        Assertions.assertEquals(ballNumbers, 2);
    }

    @Test
    public void 쓰리_볼_테스트() {
        //given
        String randomNumbers = "123";
        String inputNumbers = "231";

        //when
        int ballNumbers = referee.calculateBallNumbers(randomNumbers, inputNumbers);

        //then
        Assertions.assertEquals(ballNumbers, 3);
    }
}