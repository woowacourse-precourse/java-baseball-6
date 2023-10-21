package baseball.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class RefereeTest {

    @Test
    void 볼_0개_스트라이크_0개인_경우() {
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> user = List.of(4, 5, 6);

        int ballCount = Referee.calculateBallCount(computer, user);
        int strikeCount = Referee.calculateStrikeCount(computer, user);

        assertThat(ballCount).isEqualTo(0);
        assertThat(strikeCount).isEqualTo(0);
    }

    @Test
    void 볼_0개_스트라이크_1개인_경우() {
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> user = List.of(1, 8, 9);

        int ballCount = Referee.calculateBallCount(computer, user);
        int strikeCount = Referee.calculateStrikeCount(computer, user);

        assertThat(ballCount).isEqualTo(0);
        assertThat(strikeCount).isEqualTo(1);
    }

    @Test
    void 볼_0개_스트라이크_2개인_경우() {
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> user = List.of(1, 2, 9);

        int ballCount = Referee.calculateBallCount(computer, user);
        int strikeCount = Referee.calculateStrikeCount(computer, user);

        assertThat(ballCount).isEqualTo(0);
        assertThat(strikeCount).isEqualTo(2);
    }

    @Test
    void 볼_0개_스트라이크_3개인_경우() {
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> user = List.of(1, 2, 3);

        int ballCount = Referee.calculateBallCount(computer, user);
        int strikeCount = Referee.calculateStrikeCount(computer, user);

        assertThat(ballCount).isEqualTo(0);
        assertThat(strikeCount).isEqualTo(3);
    }

    @Test
    void 볼_1개_스트라이크_0개인_경우() {
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> user = List.of(8, 9, 1);

        int ballCount = Referee.calculateBallCount(computer, user);
        int strikeCount = Referee.calculateStrikeCount(computer, user);

        assertThat(ballCount).isEqualTo(1);
        assertThat(strikeCount).isEqualTo(0);
    }

    @Test
    void 볼_1개_스트라이크_1개인_경우() {
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> user = List.of(1, 3, 9);

        int ballCount = Referee.calculateBallCount(computer, user);
        int strikeCount = Referee.calculateStrikeCount(computer, user);

        assertThat(ballCount).isEqualTo(1);
        assertThat(strikeCount).isEqualTo(1);
    }

    @Test
    void 볼_1개_스트라이크_2개인_경우() {
        //나올 수 없는 경우
    }

    @Test
    void 볼_2개_스트라이크_0개인_경우() {
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> user = List.of(9, 3, 2);

        int ballCount = Referee.calculateBallCount(computer, user);
        int strikeCount = Referee.calculateStrikeCount(computer, user);

        assertThat(ballCount).isEqualTo(2);
        assertThat(strikeCount).isEqualTo(0);
    }

    @Test
    void 볼_2개_스트라이크_1개인_경우() {
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> user = List.of(1, 3, 2);

        int ballCount = Referee.calculateBallCount(computer, user);
        int strikeCount = Referee.calculateStrikeCount(computer, user);

        assertThat(ballCount).isEqualTo(2);
        assertThat(strikeCount).isEqualTo(1);
    }

    @Test
    void 볼_3개_스트라이크_0개인_경우() {
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> user = List.of(3, 1, 2);

        int ballCount = Referee.calculateBallCount(computer, user);
        int strikeCount = Referee.calculateStrikeCount(computer, user);

        assertThat(ballCount).isEqualTo(3);
        assertThat(strikeCount).isEqualTo(0);
    }

}