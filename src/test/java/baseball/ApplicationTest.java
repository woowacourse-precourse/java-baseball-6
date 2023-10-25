package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.model.Computer;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 중복_숫자_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("331"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 사용자_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("asd"))
                        .isInstanceOf(IllegalArgumentException.class));

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("120"))
                        .isInstanceOf(IllegalArgumentException.class));
    }


    @Test
    @DisplayName("컴퓨터가 랜덤으로 3자리 숫자를 생성하는지 테스트")
    void 컴퓨터_숫자_생성_테스트() {
        Computer randomNumbers = Computer.createRandomNumbers();
        List<Integer> randomNumbersList = randomNumbers.getRandomNumbers();

        assertThat(randomNumbersList.size()).isEqualTo(3);
    }

    @Test
    void 컴퓨터_숫자_생성_중복_테스트() {
        Computer randomNumbers = Computer.createRandomNumbers();
        List<Integer> randomNumbersList = randomNumbers.getRandomNumbers();

        assertThat(randomNumbersList.size()).isEqualTo(new HashSet<>(randomNumbersList).size());
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
