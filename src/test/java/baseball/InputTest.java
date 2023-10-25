package baseball;

import baseball.model.ComputerRandomNumbers;
import baseball.model.GameRestart;
import baseball.validator.PlayerNumberValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputTest {
    @Test
    @DisplayName("컴퓨터 랜덤 숫자 생성 테스트")
    void 컴퓨터_랜덤_숫자_생성() {
        ComputerRandomNumbers computerRandomNumbers = new ComputerRandomNumbers();
        List<Integer> test = computerRandomNumbers.generate();

        assertThat(test.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("3자리 숫자가 아닌 경우 테스트")
    void 숫자_길이_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> PlayerNumberValidator.validateNumberLen("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("숫자가 아닌(문자) 경우 테스트")
    void 숫자이외_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> PlayerNumberValidator.validateNonInteger("1a3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("숫자에 중복 값이 있는 경우 테스트")
    void 숫자_중복값_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> PlayerNumberValidator.validateDuplicateNumber("112"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자리수에 1~9가 아닌(0) 수가 있는 경우 테스트")
    void 올바른_숫자_범위_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> PlayerNumberValidator.validateNumberRange("102"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("음수의 값을 입력한 경우 테스트")
    void 음수_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> PlayerNumberValidator.validateNumberRange("-123"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("재시작 시 1 또는 2가 아닌 경우 테스트")
    void 게임_재시작_입력_예외테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> GameRestart.validateRestartNumber("0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
