package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.start.ComputerNumbers;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.HashSet;
import java.util.List;
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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 예외_테스트_문자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("가나다"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_같은숫자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("112"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 랜덤숫자_생성() {
        //given

        //when
        ComputerNumbers computerNumbers = new ComputerNumbers();
        computerNumbers.pickAnswerNumbers();
        List<Integer> randomNumbers = computerNumbers.getComputerNumbers();

        //then
        assertThat(randomNumbers.size())
                .as("랜덤 숫자 크기 검사")
                .isEqualTo(3);

        assertThat(randomNumbers.size())
                .as("랜덤 숫자 중복 검사")
                .isEqualTo(new HashSet<>(randomNumbers).size());

        for (Integer number : randomNumbers) {
            assertThat(number)
                    .as("랜덤 숫자 범위 검사")
                    .isBetween(1, 9);
        }
    }

    @Test
    void 볼() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("512", "135", "1", "895", "589", "2");
                    assertThat(output()).contains("2볼", "3스트라이크", "3볼", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 스트라이크() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("167", "135", "1", "389", "589", "2");
                    assertThat(output())
                            .contains("1스트라이크", "3스트라이크", "2스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }
}
