package baseball.view;

import baseball.domain.GameResult;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest extends NsTest {
    private GameResult result;

    @Test
    @DisplayName("볼과 스트라이크가 모두 0이면 낫싱을 출력한다")
    void printNothing() {
        result = new GameResult(0, 0);

        run();

        assertThat(output()).isEqualTo("낫싱");
    }

    @Test
    @DisplayName("볼만 있으면 볼 개수만 출력한다")
    void printOnlyBalls() {
        result = new GameResult(2, 0);

        run();

        assertThat(output()).isEqualTo("2볼");
    }

    @Test
    @DisplayName("스트라이크만 있으면 스트라이크 개수만 출력한다")
    void printOnlyStrikes() {
        result = new GameResult(0, 2);

        run();

        assertThat(output()).isEqualTo("2스트라이크");
    }

    @Test
    @DisplayName("볼과 스트라이크 사이에 공백 하나를 넣어 출력한다")
    void printBallsAndStrikes() {
        result = new GameResult(1, 1);

        run();

        assertThat(output()).isEqualTo("1볼 1스트라이크");
    }

    @Test
    @DisplayName("정답이면 3스트라이크를 출력한다")
    void printThreeStrikes() {
        result = new GameResult(0, 3);

        run();

        assertThat(output()).isEqualTo("3스트라이크");
    }

    @Override
    public void runMain() {
        OutputView outputView = new OutputView();
        outputView.printResult(result);
    }
}