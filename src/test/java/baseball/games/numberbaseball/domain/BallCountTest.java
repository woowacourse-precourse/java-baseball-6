package baseball.games.numberbaseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallCountTest {

    @Test
    @DisplayName("스트라이크 값이 3이라면 true")
    void isThreeStrike() {
        //given
        BallCount ballCount = new BallCount(0, 3);
        //when
        boolean isThreeStrike = ballCount.isThreeStrike();
        //then
        assertThat(isThreeStrike).isTrue();
    }

    @Test
    @DisplayName("스트라이크 값이 3이 아니라면 false")
    void isNotThreeStrike() {
        //given
        BallCount ballCount = new BallCount(0, 2);
        //when
        boolean isThreeStrike = ballCount.isThreeStrike();
        //then
        assertThat(isThreeStrike).isFalse();
    }

    @Test
    @DisplayName("볼과 스트라이크가 모두 0이라면 낫싱을 출력")
    void printNothingMessage() {
        //given
        BallCount ballCount = new BallCount(0, 0);
        //when
        String ballCountMessage = ballCount.createBallCountMessage();
        //then
        assertThat(ballCountMessage).isEqualTo("낫싱");
    }

    @Test
    @DisplayName("스트라이크만 존재 하면 스트라이크 수만 출력")
    void printStrikeMessage() {
        //given
        BallCount ballCount = new BallCount(0, 1);
        //when
        String ballCountMessage = ballCount.createBallCountMessage();
        //then
        assertThat(ballCountMessage).isEqualTo("1스트라이크");
    }

    @Test
    @DisplayName("볼만 존재 하면 볼의 수만 출력")
    void printBallMessage() {
        //given
        BallCount ballCount = new BallCount(1, 0);
        //when
        String ballCountMessage = ballCount.createBallCountMessage();
        //then
        assertThat(ballCountMessage).isEqualTo("1볼");
    }

    @Test
    @DisplayName("볼과 스트라이크가 모두 0이 아니라면 둘 다 출력")
    void printBothMessage() {
        //given
        BallCount ballCount = new BallCount(1, 1);
        //when
        String ballCountMessage = ballCount.createBallCountMessage();
        //then
        assertThat(ballCountMessage).isEqualTo("1볼 1스트라이크");
    }
}