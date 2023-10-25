package baseball.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class RefereeAndHintTest {

    @Test
    void 볼_0개_스트라이크_0개_낫싱() {
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> user = List.of(4, 5, 6);

        int ballCount = Referee.calculateBallCount(computer, user);
        int strikeCount = Referee.calculateStrikeCount(computer, user);

        String hint = Hint.makeHint(ballCount, strikeCount);

        assertThat(hint).isEqualTo("낫싱");
    }

    @Test
    void 볼_0개_스트라이크_1개() {
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> user = List.of(1, 8, 9);

        int ballCount = Referee.calculateBallCount(computer, user);
        int strikeCount = Referee.calculateStrikeCount(computer, user);

        String hint = Hint.makeHint(ballCount, strikeCount);

        assertThat(hint).isEqualTo("1스트라이크");
    }

    @Test
    void 볼_0개_스트라이크_2개() {
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> user = List.of(1, 2, 9);

        int ballCount = Referee.calculateBallCount(computer, user);
        int strikeCount = Referee.calculateStrikeCount(computer, user);

        String hint = Hint.makeHint(ballCount, strikeCount);

        assertThat(hint).isEqualTo("2스트라이크");
    }

    @Test
    void 볼_0개_스트라이크_3개() {
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> user = List.of(1, 2, 3);

        int ballCount = Referee.calculateBallCount(computer, user);
        int strikeCount = Referee.calculateStrikeCount(computer, user);

        String hint = Hint.makeHint(ballCount, strikeCount);

        assertThat(hint).isEqualTo("3스트라이크");
    }

    @Test
    void 볼_1개_스트라이크_0개() {
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> user = List.of(8, 9, 1);

        int ballCount = Referee.calculateBallCount(computer, user);
        int strikeCount = Referee.calculateStrikeCount(computer, user);

        String hint = Hint.makeHint(ballCount, strikeCount);

        assertThat(hint).isEqualTo("1볼");
    }

    @Test
    void 볼_1개_스트라이크_1개() {
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> user = List.of(1, 3, 9);

        int ballCount = Referee.calculateBallCount(computer, user);
        int strikeCount = Referee.calculateStrikeCount(computer, user);

        String hint = Hint.makeHint(ballCount, strikeCount);

        assertThat(hint).isEqualTo("1볼 1스트라이크");
    }

    @Test
    void 볼_1개_스트라이크_2개() {
        //나올 수 없는 경우
    }

    @Test
    void 볼_2개_스트라이크_0개() {
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> user = List.of(9, 3, 2);

        int ballCount = Referee.calculateBallCount(computer, user);
        int strikeCount = Referee.calculateStrikeCount(computer, user);

        String hint = Hint.makeHint(ballCount, strikeCount);

        assertThat(hint).isEqualTo("2볼");
    }

    @Test
    void 볼_2개_스트라이크_1개() {
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> user = List.of(1, 3, 2);

        int ballCount = Referee.calculateBallCount(computer, user);
        int strikeCount = Referee.calculateStrikeCount(computer, user);

        String hint = Hint.makeHint(ballCount, strikeCount);

        assertThat(hint).isEqualTo("2볼 1스트라이크");
    }

    @Test
    void 볼_3개_스트라이크_0개() {
        List<Integer> computer = List.of(1, 2, 3);
        List<Integer> user = List.of(3, 1, 2);

        int ballCount = Referee.calculateBallCount(computer, user);
        int strikeCount = Referee.calculateStrikeCount(computer, user);

        String hint = Hint.makeHint(ballCount, strikeCount);

        assertThat(hint).isEqualTo("3볼");
    }

}