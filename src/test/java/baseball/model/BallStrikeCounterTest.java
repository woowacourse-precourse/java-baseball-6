package baseball.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallStrikeCounterTest {
    BallStrikeCounter ballStrikeCounter = new BallStrikeCounter();
    List<Integer> userNumber = null;
    List<Integer> computerNumber = new ArrayList<>();

    @BeforeEach
    void reset() {
        ballStrikeCounter.resetBallStrike();
        computerNumber = new ArrayList<>(Arrays.asList(4, 8, 6));
    }

    @Test
    @DisplayName("reset 테스트")
    void testReset() {
        Assertions.assertThat(ballStrikeCounter.toString()).isEqualTo("낫싱");
    }

    @Test
    @DisplayName("3스트라이크")
    void threeStrikeTest() {
        //given
        userNumber = computerNumber;

        //when
        ballStrikeCounter.countBallStrike(userNumber, computerNumber);

        //then
        Assertions.assertThat(ballStrikeCounter.toString()).isEqualTo("3스트라이크");
    }

    @Test
    @DisplayName("스트라이크만 존재")
    void onlyStrikeTest() {
        //given
        userNumber = new ArrayList<>(Arrays.asList(4, 5, 9));

        //when
        ballStrikeCounter.countBallStrike(userNumber, computerNumber);

        //then
        Assertions.assertThat(ballStrikeCounter.toString()).isEqualTo("1스트라이크");
    }

    @Test
    @DisplayName("볼만 존재")
    void onlyBallTest() {
        //given
        userNumber = new ArrayList<>(Arrays.asList(5, 4, 9));

        //when
        ballStrikeCounter.countBallStrike(userNumber, computerNumber);

        //then
        Assertions.assertThat(ballStrikeCounter.toString()).isEqualTo("1볼 ");
    }

    @Test
    @DisplayName("낫싱")
    void nothingTest() {
        //given
        userNumber = new ArrayList<>(Arrays.asList(1, 2, 3));

        //when
        ballStrikeCounter.countBallStrike(userNumber, computerNumber);

        //then
        Assertions.assertThat(ballStrikeCounter.toString()).isEqualTo("낫싱");
    }
}