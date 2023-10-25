package baseball;

import static baseball.global.BaseballConstant.GUESS_NUMBER_SIZE;
import static baseball.global.BaseballConstant.MAX_RANGE;
import static baseball.global.BaseballConstant.MIN_RANGE;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import baseball.domain.Computer;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

public class BaseballFeatureTest extends NsTest {

    @Test
    void 랜덤하게_고른_숫자가_1에서_9까지의_서로_다른_3자리_숫자인지_확인() {
        Computer computer = new Computer();
        int count = (int) IntStream.rangeClosed(MIN_RANGE, MAX_RANGE)
                .filter(computer::numbersContains)
                .count();
        assertThat(count).isEqualTo(GUESS_NUMBER_SIZE);
    }

    @Test
    void 입력_값이_빈_값일_경우_예외_처리() {
        List<String> testInputs = List.of(" ", "   ", "    ", "\n", " 1 ", "1 2 3");
        for (String input : testInputs) {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(input))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }

    @Test
    void 입력_값이_숫자가_아닐_경우_예외_처리() {
        List<String> testInputs = List.of("우테코", "WTC", "!@#", "우T#");
        for (String input : testInputs) {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(input))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }

    @Test
    void 입력_값이_3자리가_아닐_경우_예외_처리() {
        List<String> testInputs = List.of("1", "22", "4444", "55555");
        for (String input : testInputs) {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(input))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }

    @Test
    void 입력_값_중_0이_있을_경우_예외_처리() {
        List<String> testInputs = List.of("012", "102", "120");
        for (String input : testInputs) {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(input))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }

    @Test
    void 입력_값_중_같은_숫자가_있을_경우_예외_처리() {
        List<String> testInputs = List.of("112", "121", "211");
        for (String input : testInputs) {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(input))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }

    @Test
    void 게임종료_후_재시작_여부_입력_값이_숫자가_아닐_경우_예외_처리() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("123", "a"))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                1, 3, 5
        );
    }

    @Test
    void 게임종료_후_재시작_여부_입력_값이_정해진_숫자가_아닐_경우_예외_처리() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("123", "3"))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                1, 3, 5
        );
    }
    
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
