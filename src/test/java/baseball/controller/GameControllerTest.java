package baseball.controller;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import baseball.config.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameControllerTest {

    @Test
    @DisplayName("입력 값이 3자리 수를 초과했을 때 IllegalArgumentException 이 잘 던져지는지 확인")
    void isOutOfRange() {
        AppConfig appConfig = new AppConfig();
        GameController gameController = appConfig.gameController();

        assertThatThrownBy(() -> gameController.process("1234")).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "12"})
    @DisplayName("입력 값이 3자리 수 미만일 때 IllegalArgumentException 이 잘 던져지는지 확인")
    void isShortInputLength(String input) {
        AppConfig appConfig = new AppConfig();
        GameController gameController = appConfig.gameController();

        assertThatThrownBy(() -> gameController.process(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"#aa", "1a2", "-12", "ㅁ12"})
    @DisplayName("입력 값에 숫자가 아닌 값이 섞여있을 때 IllegalArgumentException 이 잘 던져지는지 확인")
    void isNoneNumericInput(String input) {
        AppConfig appConfig = new AppConfig();
        GameController gameController = appConfig.gameController();

        assertThatThrownBy(() -> gameController.process(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"112", "122", "111", "334"})
    @DisplayName("입력 값에 중복 값이 섞여있을 때 IllegalArgumentException 이 잘 던져지는지 확인")
    void isDuplicatedInput(String input) {
        AppConfig appConfig = new AppConfig();
        GameController gameController = appConfig.gameController();

        assertThatThrownBy(() -> gameController.process(input)).isInstanceOf(IllegalArgumentException.class);
    }

}