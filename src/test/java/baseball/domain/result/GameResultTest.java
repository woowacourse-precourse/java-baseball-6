package baseball.domain.result;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameResultTest {

    @Test
    @DisplayName("2스트라이크 1볼인 경우 GameResult 는 '2 스트라이크 1 볼' 을 반환한다.")
    void gaeResultTest1() {
        GameResult gameResult = new GameResult();
        gameResult.update(BallResult.STRIKE);
        gameResult.update(BallResult.STRIKE);
        gameResult.update(BallResult.BALL);
        Assertions.assertThat(gameResult.getResult()).isEqualTo("1볼 2스트라이크");
    }

    @Test
    @DisplayName("1스트라이크 1볼인 1낫띵인 경우 GameResult 는 '1 스트라이크 1 볼' 을 반환한다.")
    void gaeResultTest2() {
        GameResult gameResult = new GameResult();
        gameResult.update(BallResult.STRIKE);
        gameResult.update(BallResult.BALL);
        gameResult.update(BallResult.NOTHING);
        Assertions.assertThat(gameResult.getResult()).isEqualTo("1볼 1스트라이크");
    }

    @Test
    @DisplayName("1볼 2낫띵인 경우 GameResult 는 '1 볼' 을 반환한다.")
    void gaeResultTest3() {
        GameResult gameResult = new GameResult();
        gameResult.update(BallResult.BALL);
        gameResult.update(BallResult.NOTHING);
        gameResult.update(BallResult.NOTHING);
        Assertions.assertThat(gameResult.getResult()).isEqualTo("1볼");
    }

    @Test
    @DisplayName("3스트라이크 경우 GameResult 는 '3 스트라이크' 을 반환한다.")
    void gaeResultTest4() {
        GameResult gameResult = new GameResult();
        gameResult.update(BallResult.STRIKE);
        gameResult.update(BallResult.STRIKE);
        gameResult.update(BallResult.STRIKE);
        Assertions.assertThat(gameResult.getResult()).isEqualTo("3스트라이크");
    }

    @Test
    @DisplayName("3 낫띵인 경우 GameResult 는 '낫띵' 을 반환한다.")
    void gaeResultTest5() {
        GameResult gameResult = new GameResult();
        gameResult.update(BallResult.NOTHING);
        gameResult.update(BallResult.NOTHING);
        gameResult.update(BallResult.NOTHING);
        Assertions.assertThat(gameResult.getResult()).isEqualTo("낫싱");
    }

    @Test
    @DisplayName("3스트라이크 경우 GameResult 의 isGameEnd 메서드가 true 를 반환한다 ")
    void isGameEndTest_1() {
        GameResult gameResult = new GameResult();
        gameResult.update(BallResult.STRIKE);
        gameResult.update(BallResult.STRIKE);
        gameResult.update(BallResult.STRIKE);
        Assertions.assertThat(gameResult.isGameEnd()).isTrue();
    }

    @Test
    @DisplayName("3스트라이크가 아닌경우 GameResult 의 isGameEnd 메서드가 false 를 반환한다 ")
    void isGameEndTest_2() {
        GameResult gameResult = new GameResult();
        gameResult.update(BallResult.STRIKE);
        gameResult.update(BallResult.STRIKE);
        gameResult.update(BallResult.BALL);
        Assertions.assertThat(gameResult.isGameEnd()).isFalse();
    }
}
