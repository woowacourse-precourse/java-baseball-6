package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallContainerTest {
    static BallContainer ballContainer;

    @BeforeAll
    static void setUp() {
        ballContainer = BallContainer.getFromNumbers(List.of(5, 6, 2));
    }

    @DisplayName("숫자 리스트를 List<Ball>로 정확하게 매핑하는지 확인합니다.")
    @Test
    void getFromNumbers_MakeCorrectBallList() {
        List<Ball> expected = List.of(
                new Ball(5, 0),
                new Ball(6, 1),
                new Ball(2, 2));

        assertThat(ballContainer.getBalls()).isEqualTo(expected);
    }

    @DisplayName("3스트라이크 결과를 정확히 리턴하는지 확인합니다.")
    @Test
    void pitch_is3Strike() {
        BallContainer otherContainer = BallContainer.getFromNumbers(List.of(5, 6, 2));

        PitchResult expected = new PitchResult(3, 0);

        assertThat(ballContainer.pitch(otherContainer))
                .isEqualTo(expected);
    }

    @DisplayName("2스트라이크 결과를 정확히 리턴하는지 확인합니다.")
    @Test
    void pitch_is2Strike() {
        BallContainer otherContainer = BallContainer.getFromNumbers(List.of(5, 6, 7));

        PitchResult expected = new PitchResult(2, 0);

        assertThat(ballContainer.pitch(otherContainer))
                .isEqualTo(expected);
    }

    @DisplayName("1스트라이크 결과를 정확히 리턴하는지 확인합니다.")
    @Test
    void pitch_is1Strike() {
        BallContainer otherContainer = BallContainer.getFromNumbers(List.of(5, 1, 9));
        PitchResult expected = new PitchResult(1, 0);

        assertThat(ballContainer.pitch(otherContainer))
                .isEqualTo(expected);
    }

    @DisplayName("2볼 1스트라이크 결과를 정확히 리턴하는지 확인합니다.")
    @Test
    void pitch_is1Strike2Ball() {
        BallContainer otherContainer = BallContainer.getFromNumbers(List.of(6, 5, 2));

        PitchResult expected = new PitchResult(1, 2);

        assertThat(ballContainer.pitch(otherContainer))
                .isEqualTo(expected);
    }

    @DisplayName("1볼 1스트라이크 결과를 정확히 리턴하는지 확인합니다.")
    @Test
    void pitch_is1Strike1Ball() {
        BallContainer otherContainer = BallContainer.getFromNumbers(List.of(2, 6, 1));

        PitchResult expected = new PitchResult(1, 1);

        assertThat(ballContainer.pitch(otherContainer))
                .isEqualTo(expected);
    }

    @DisplayName("2볼 결과를 정확히 리턴하는지 확인합니다.")
    @Test
    void pitch_is2Ball() {
        BallContainer otherContainer = BallContainer.getFromNumbers(List.of(2, 5, 8));

        PitchResult expected = new PitchResult(0, 2);

        assertThat(ballContainer.pitch(otherContainer))
                .isEqualTo(expected);
    }

    @DisplayName("1볼 결과를 정확히 리턴하는지 확인합니다.")
    @Test
    void pitch_is1Ball() {
        BallContainer otherContainer = BallContainer.getFromNumbers(List.of(1, 5, 8));

        PitchResult expected = new PitchResult(0, 1);

        assertThat(ballContainer.pitch(otherContainer))
                .isEqualTo(expected);
    }

    @DisplayName("낫싱 결과를 정확히 리턴하는지 확인합니다.")
    @Test
    void pitch_isNothing() {
        BallContainer otherContainer = BallContainer.getFromNumbers(List.of(1, 3, 9));

        PitchResult expected = new PitchResult(0, 0);

        assertThat(ballContainer.pitch(otherContainer))
                .isEqualTo(expected);
    }
}