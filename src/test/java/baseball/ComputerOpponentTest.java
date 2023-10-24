package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerOpponentTest {

    @Test
    void 컴퓨터_상대의_대답_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    //given
                    ComputerOpponent opponent = new ComputerOpponent();

                    //when
                    List<BaseballResult> results = List.of(
                            opponent.guess(List.of(1, 2, 3)), // 3s
                            opponent.guess(List.of(1, 3, 2)), // 2b 1s
                            opponent.guess(List.of(2, 1, 3)), // 2b 1s
                            opponent.guess(List.of(2, 3, 1)), // 3b
                            opponent.guess(List.of(3, 1, 2)), // 3b
                            opponent.guess(List.of(3, 2, 1)) // 2b 1s
                    );

                    //then
                    Boolean[] truth = {true, false, false, false, false, false};
                    assertThat(results.stream().map(BaseballResult::isCorrect).toArray()).isEqualTo(truth);

                    String[] listOfBalls = {"3스트라이크", "2볼 1스트라이크", "2볼 1스트라이크", "3볼", "3볼", "2볼 1스트라이크"};
                    assertThat(results.stream().map(BaseballResult::toHangul).toArray()).isEqualTo(listOfBalls);
                },
                1, 2, 3
        );
    }
}