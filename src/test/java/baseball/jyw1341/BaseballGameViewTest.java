package baseball.jyw1341;

import baseball.BallCount;
import baseball.BaseballGameView;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BaseballGameViewTest {

    BaseballGameView baseballGameView = new BaseballGameView();

    @Test
    void testPrintBallCountAll(){
        BallCount ballCount = new BallCount();
        ballCount.setStrike(1);
        ballCount.setBall(2);

        String ballCountMessage = baseballGameView.printBallCount(ballCount);

        Assertions.assertEquals("2볼 1스트라이크", ballCountMessage);
    }

    @Test
    void testPrintBallCountOnlyStrike(){
        BallCount ballCount = new BallCount();
        ballCount.setStrike(1);

        String ballCountMessage = baseballGameView.printBallCount(ballCount);

        Assertions.assertEquals("1스트라이크", ballCountMessage);
    }

    @Test
    void testPrintBallCountOnlyBall(){
        BallCount ballCount = new BallCount();
        ballCount.setBall(2);

        String ballCountMessage = baseballGameView.printBallCount(ballCount);

        Assertions.assertEquals("2볼", ballCountMessage);
    }

    @Test
    void testPrintBallCountNothing(){
        BallCount ballCount = new BallCount();

        String ballCountMessage = baseballGameView.printBallCount(ballCount);

        Assertions.assertEquals("낫싱", ballCountMessage);
    }
}