package baseball.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

enum BALL_COUNT {
    NOTHING("낫싱"),
    ONE_BALL("1볼"),
    TWO_BALL("2볼"),
    THREE_BALL("3볼"),
    ONE_STRIKE("1스트라이크"),
    TWO_STRIKE("2스트라이크"),
    THREE_STRIKE("3스트라이크");

    private final String value;

    BALL_COUNT(String value){
        this.value = value;

    }

    public String getValue(){
        return value;
    }
}

class BaseballServiceTest {

    @Mock
    BaseballService baseballService;

    @BeforeEach
    private void before() {
        baseballService = new BaseballService();
    }

    @Test
    void nothingTest() {
        String result = baseballService.getGameResult("123", "456");

        Assertions.assertEquals(result, BALL_COUNT.NOTHING.getValue());
    }

    @Test
    void oneBallTest() {
        String result = baseballService.getGameResult("123", "451");

        Assertions.assertEquals(result, BALL_COUNT.ONE_BALL.getValue());
    }

    @Test
    void twoBallTest() {
        String result = baseballService.getGameResult("123", "412");

        Assertions.assertEquals(result, BALL_COUNT.TWO_BALL.getValue());
    }

    @Test
    void threeBallTest() {
        String result = baseballService.getGameResult("123", "231");

        Assertions.assertEquals(result, BALL_COUNT.THREE_BALL.getValue());
    }

    @Test
    void oneStrikeTest() {
        String result = baseballService.getGameResult("123", "145");

        Assertions.assertEquals(result, BALL_COUNT.ONE_STRIKE.getValue());
    }

    @Test
    void twoStrikeTest() {
        String result = baseballService.getGameResult("123", "124");

        Assertions.assertEquals(result, BALL_COUNT.TWO_STRIKE.getValue());
    }

    @Test
    void threeStrikeTest() {
        String result = baseballService.getGameResult("123", "123");

        Assertions.assertEquals(result, BALL_COUNT.THREE_STRIKE.getValue());
    }

    @Test
    void oneBallOneStrikeTest() {
        String result = baseballService.getGameResult("123", "134");

        Assertions.assertEquals(result, BALL_COUNT.ONE_BALL.getValue() + " " + BALL_COUNT.ONE_STRIKE.getValue());
    }

    @Test
    void twoBallOneStrikeTest() {
        String result = baseballService.getGameResult("123", "132");

        Assertions.assertEquals(result, BALL_COUNT.TWO_BALL.getValue() + " " + BALL_COUNT.ONE_STRIKE.getValue());
    }
}