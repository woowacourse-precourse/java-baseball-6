package baseball.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.Test;

public class GraderTest {

    @Test
    void 정답과_제출한_숫자의_값과_위치가_모두_일치하는_경우_스트라이크로_채점한다() {
        List<Integer> answer = List.of(1, 2, 3, 4, 5);
        Grader grader = new Grader(answer);

        List<Integer> playerNumbers = List.copyOf(answer);
        ScoreBoard scoreBoard = grader.grade(playerNumbers);

        assertAll(
            () -> assertThat(scoreBoard.strikeCount()).isEqualTo(5),
            () -> assertThat(scoreBoard.ballCount()).isEqualTo(0)
        );
    }

    @Test
    void 정답과_제출한_숫자의_값만_일치하고_숫자는_다른_경우_볼로_채점한다() {
        List<Integer> answer = List.of(1, 2, 3);
        Grader grader = new Grader(answer);

        List<Integer> playerNumbers = List.of(3, 2, 1);
        ScoreBoard scoreBoard = grader.grade(playerNumbers);

        assertAll(
            () -> assertThat(scoreBoard.ballCount()).isEqualTo(2),
            () -> assertThat(scoreBoard.strikeCount()).isEqualTo(1)
        );
    }

    @Test
    void 일치하는_숫자가_한개도_없는_경우_볼과_스트라이크를_0개로_채점한다() {
        List<Integer> answer = List.of(1, 2, 3, 4);
        Grader grader = new Grader(answer);

        List<Integer> playerNumbers = List.of(5, 6, 7, 8);
        ScoreBoard scoreBoard = grader.grade(playerNumbers);

        assertAll(
            () -> assertThat(scoreBoard.ballCount()).isEqualTo(0),
            () -> assertThat(scoreBoard.strikeCount()).isEqualTo(0)
        );
    }

    @Test
    void 정답과_제출한_숫자의_크기가_다른_경우_예외를_발생시킨다() {
        List<Integer> answer = List.of(1, 2, 3, 4);
        Grader answerSize4Grader = new Grader(answer);

        List<Integer> size2Numbers = List.of(1, 2);
        List<Integer> size5Numbers = List.of(1, 2, 3, 4, 5);

        assertAll(
            () -> assertThatThrownBy(
                () -> answerSize4Grader.grade(size2Numbers))
                .isInstanceOf(IllegalArgumentException.class),

            () -> assertThatThrownBy(
                () -> answerSize4Grader.grade(size5Numbers))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
