package baseball;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @Test
    void Three_스트라이크일_경우_true를_반환한다() {
        Result result = new Result(0, 3);

        boolean isThreeStrike = result.isThreeStrike();

        assertTrue(isThreeStrike);
    }

    @Test
    void Three_스트라이크가_아닐_경우_false를_반환한다() {
        Result result = new Result(2, 1);

        boolean isThreeStrike = result.isThreeStrike();

        assertFalse(isThreeStrike);
    }

    @Test
    void Strike만_있는_Result_결과를_한글_String으로_반환한다() {
        int ballCount = 0;
        int strikeCount = 3;
        Result result = new Result(ballCount, strikeCount);

        String resultInKorean = result.getResultInKorean();

        assertEquals(resultInKorean, strikeCount + OutputMessage.STRIKE.message);
    }

    @Test
    void Ball만_있는_Result_결과를_한글_String으로_반환한다() {
        int ballCount = 3;
        int strikeCount = 0;
        Result result = new Result(ballCount, strikeCount);

        String resultInKorean = result.getResultInKorean();

        assertEquals(resultInKorean, ballCount + OutputMessage.BALL.message);
    }

    @Test
    void Strike와_Ball이_있는_Result_결과를_한글_String으로_반환한다() {
        int ballCount = 2;
        int strikeCount = 1;
        Result result = new Result(ballCount, strikeCount);

        String resultInKorean = result.getResultInKorean();

        assertEquals(resultInKorean, ballCount + OutputMessage.BALL.message + " " + strikeCount + OutputMessage.STRIKE.message);
    }

    @Test
    void 낫싱_Result_결과를_한글_String으로_반환한다() {
        int ballCount = 0;
        int strikeCount = 0;
        Result result = new Result(ballCount, strikeCount);

        String resultInKorean = result.getResultInKorean();

        assertEquals(resultInKorean, OutputMessage.NOTHING.message);
    }

    @Test
    void 볼과_스트라이크_점수가_같다면_다른_인스턴스라도_같다고_인식한다() {
        Result result1 = new Result(2, 1);
        Result result2 = new Result(2, 1);

        assertEquals(result1, result2);
    }
}