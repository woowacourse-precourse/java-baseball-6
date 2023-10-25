package baseball.model;

import baseball.Result;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JudgeTest {
    private final Judge judge = new Judge();

    @Nested
    class makeResultTest {

        @Test
        void 낫싱() {
            List<Integer> answer = List.of(2, 4, 6);
            List<Integer> playerNumbers = List.of(1, 3, 5);

            assertThat(judge.makeResult(answer, playerNumbers)).isEqualTo(new Result(0, 0));
        }

        @Test
        void 볼_1개() {
            List<Integer> answer = List.of(2, 4, 6);
            List<Integer> playerNumbers = List.of(3, 2, 5);

            assertThat(judge.makeResult(answer, playerNumbers)).isEqualTo(new Result(1, 0));
        }
        @Test
        void 볼_1개_스트라이크_1개() {
            List<Integer> answer = List.of(2, 5, 6);
            List<Integer> playerNumbers = List.of(2, 3, 5);

            assertThat(judge.makeResult(answer, playerNumbers)).isEqualTo(new Result(1, 1));
        }

        @Test
        void 스트라이크_1개() {
            List<Integer> answer = List.of(2, 4, 6);
            List<Integer> playerNumbers = List.of(2, 3, 5);

            assertThat(judge.makeResult(answer, playerNumbers)).isEqualTo(new Result(0, 1));
        }

        @Test
        void 스트라이크_3개() {
            List<Integer> answer = List.of(2, 4, 6);
            List<Integer> playerNumbers = List.of(2, 4, 6);

            assertThat(judge.makeResult(answer, playerNumbers)).isEqualTo(new Result(0, 3));
        }
    }

    @Nested
    class checkGameOver {
        @Test
        void 결과가_3스트라이크일_경우_게임종료() {
            // stub
            Result result = Mockito.mock(Result.class);
            Mockito.when(result.isAllStrike()).thenReturn(true);

            assertThat(judge.checkGameOver(result)).isTrue();
        }
    }
}
