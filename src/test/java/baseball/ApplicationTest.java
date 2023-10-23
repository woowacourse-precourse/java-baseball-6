package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
    void 컴퓨터_생성_숫자_3자리_확인() {
        var computer = new Computer();
        computer.generateRandomNum();
        assertThat(computer.getRandomNum().size()).isEqualTo(3);
    }

    @Test
    void 컴퓨터_생성_숫자_중복_확인() {
        var computer = new Computer();
        computer.generateRandomNum();
        assertThat(computer.getRandomNum()).doesNotHaveDuplicates();
    }

    @ParameterizedTest
    @ValueSource(strings = {"a2", "12", ""})
    void 재시작_입력_예외테스트(String string) {
        var inputValidator = new InputValidator();
        assertThatThrownBy(() -> inputValidator.restartInputValidator(string))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
