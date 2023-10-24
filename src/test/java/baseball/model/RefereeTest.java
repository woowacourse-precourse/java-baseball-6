package baseball.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RefereeTest {

    public static final int ZERO_STRIKE = 0;
    public static final int ONE_STRIKE = 1;
    public static final int TWO_STRIKE = 2;
    public static final int THREE_STRIKE = 3;
    public static final int ZERO_BALL = 0;
    public static final int ONE_BALL = 1;
    public static final int TWO_BALL = 2;
    public static final int THREE_BALL = 3;
    public static final String RANDOM_NUMBER = "123";

    private Referee referee = new Referee();

    @Test
    public void 제로_스트라이크_테스트() {
        //given
        final String inputNumbers = "456";

        //when
        referee.calculateBallAndStrikeNumber(RANDOM_NUMBER, inputNumbers);

        //then
        Assertions.assertEquals(referee.getStrikeNumber(), ZERO_STRIKE);
    }

    @Test
    public void 원_스트라이크_테스트() {
        //given
        final String inputNumbers = "132";

        //when
        referee.calculateBallAndStrikeNumber(RANDOM_NUMBER, inputNumbers);

        //then
        Assertions.assertEquals(referee.getStrikeNumber(), ONE_STRIKE);
    }

    @Test
    public void 투_스트라이크_테스트() {
        //given
        final String inputNumbers = "125";

        //when
        referee.calculateBallAndStrikeNumber(RANDOM_NUMBER, inputNumbers);

        //then
        Assertions.assertEquals(referee.getStrikeNumber(), TWO_STRIKE);
    }

    @Test
    public void 쓰리_스트라이크_테스트() {
        //given
        final String inputNumbers = "123";

        //when
        referee.calculateBallAndStrikeNumber(RANDOM_NUMBER, inputNumbers);

        //then
        Assertions.assertEquals(referee.getStrikeNumber(), THREE_STRIKE);
    }

    @Test
    public void 제로_볼_테스트() {
        //given
        final String inputNumbers = "456";

        //when
        referee.calculateBallAndStrikeNumber(RANDOM_NUMBER, inputNumbers);

        //then
        Assertions.assertEquals(referee.getBallNumber(), ZERO_BALL);
    }

    @Test
    public void 원_볼_테스트() {
        //given
        final String inputNumbers = "634";

        //when
        referee.calculateBallAndStrikeNumber(RANDOM_NUMBER, inputNumbers);

        //then
        Assertions.assertEquals(referee.getBallNumber(), ONE_BALL);
    }

    @Test
    public void 투_볼_테스트() {
        //given
        final String inputNumbers = "632";

        //when
        referee.calculateBallAndStrikeNumber(RANDOM_NUMBER, inputNumbers);

        //then
        Assertions.assertEquals(referee.getBallNumber(), TWO_BALL);
    }

    @Test
    public void 쓰리_볼_테스트() {
        //given
        final String inputNumbers = "231";

        //when
        referee.calculateBallAndStrikeNumber(RANDOM_NUMBER, inputNumbers);

        //then
        Assertions.assertEquals(referee.getBallNumber(), THREE_BALL);
    }

    @Test
    public void 낫싱_판별_테스트() {
        //given
        final String inputNumber = "456";

        //when
        referee.calculateBallAndStrikeNumber(RANDOM_NUMBER, inputNumber);

        //then
        Assertions.assertTrue(referee.isNothing());
    }

    @Test
    public void 볼만_있는_경우_판별_테스트() {
        //given
        final String inputNumber = "216";

        //when
        referee.calculateBallAndStrikeNumber(RANDOM_NUMBER, inputNumber);

        //then
        Assertions.assertTrue(referee.isOnlyBall());
    }

    @Test
    public void 스트라이크만_있는_경우_판별_테스트() {
        //given
        final String inputNumber = "145";

        //when
        referee.calculateBallAndStrikeNumber(RANDOM_NUMBER, inputNumber);

        //then
        Assertions.assertTrue(referee.isOnlyStrike());
    }

    @Test
    public void 둘_다_있는_경우_판별_테스트() {
        //given
        final String inputNumber = "132";

        //when
        referee.calculateBallAndStrikeNumber(RANDOM_NUMBER, inputNumber);

        //then
        Assertions.assertTrue(referee.isStrikeAndBall());
    }

    @Test
    public void 쓰리_스트라이크_판별_테스트() {
        //given
        final String inputNumber = "123";

        //when
        referee.calculateBallAndStrikeNumber(RANDOM_NUMBER, inputNumber);

        //then
        Assertions.assertTrue(referee.isThreeStrike());
    }
}