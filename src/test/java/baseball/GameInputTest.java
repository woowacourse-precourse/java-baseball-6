package baseball;

import static baseball.status.ErrorCode.INVALID_DISTINCT_INPUT;
import static baseball.status.ErrorCode.INVALID_FORMAT_INPUT;
import static baseball.status.ErrorCode.INVALID_FORMAT_INPUT2;
import static baseball.status.ErrorCode.INVALID_LENGTH_INPUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import baseball.game.impl.GameInputImpl;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameInputTest {

    @Test
    @DisplayName("올바른 입력_서로 다른 3자리 수")
    void setInputTest() {
        GameInputImpl gameInput = new GameInputImpl();
        List<Integer> inputNum = gameInput.getIntegerInput("123");
        assertThat(inputNum).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("잘못된 입력_3자리 수보다 적은 경우")
    void validationInputTest2() {
        GameInputImpl gameInput = new GameInputImpl();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> gameInput.getIntegerInput("12"));
        IllegalArgumentException exception2 = assertThrows(
                IllegalArgumentException.class, () -> gameInput.getIntegerInput("1"));
        IllegalArgumentException exception3 = assertThrows(
                IllegalArgumentException.class, () -> gameInput.getIntegerInput(""));

        assertThat(exception.getMessage()).isEqualTo(INVALID_LENGTH_INPUT.getMsg());
        assertThat(exception2.getMessage()).isEqualTo(INVALID_LENGTH_INPUT.getMsg());
        assertThat(exception3.getMessage()).isEqualTo(INVALID_LENGTH_INPUT.getMsg());
    }

    @Test
    @DisplayName("잘못된 입력_3자리 수보다 많은 경우")
    void validationInputTest3() {
        GameInputImpl gameInput = new GameInputImpl();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> gameInput.getIntegerInput("1234"));

        assertThat(exception.getMessage()).isEqualTo(INVALID_LENGTH_INPUT.getMsg());
    }

    @Test
    @DisplayName("잘못된 입력_숫자 대신 문자인 경우")
    void validationInputTest4() {
        GameInputImpl gameInput = new GameInputImpl();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> gameInput.getIntegerInput("12a"));
        IllegalArgumentException exception2 = assertThrows(
                IllegalArgumentException.class, () -> gameInput.getIntegerInput("1.5"));
        IllegalArgumentException exception3 = assertThrows(
                IllegalArgumentException.class, () -> gameInput.getIntegerInput("pen"));

        assertThat(exception.getMessage()).isEqualTo(INVALID_FORMAT_INPUT.getMsg());
        assertThat(exception2.getMessage()).isEqualTo(INVALID_FORMAT_INPUT.getMsg());
        assertThat(exception3.getMessage()).isEqualTo(INVALID_FORMAT_INPUT.getMsg());
    }

    @Test
    @DisplayName("잘못된 입력_1 ~ 9에 해당하지 않는 경우")
    void validationInputTest5() {
        GameInputImpl gameInput = new GameInputImpl();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> gameInput.getIntegerInput("120"));

        assertThat(exception.getMessage()).isEqualTo(INVALID_FORMAT_INPUT.getMsg());
    }

    @Test
    @DisplayName("잘못된 입력_중복된 숫자가 존재하는 경우")
    void validationInputTest6() {
        GameInputImpl gameInput = new GameInputImpl();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> gameInput.getIntegerInput("151"));
        IllegalArgumentException exception2 = assertThrows(
                IllegalArgumentException.class, () -> gameInput.getIntegerInput("133"));

        assertThat(exception.getMessage()).isEqualTo(INVALID_DISTINCT_INPUT.getMsg());
        assertThat(exception2.getMessage()).isEqualTo(INVALID_DISTINCT_INPUT.getMsg());
    }

    @Test
    @DisplayName("올바른 입력_게임 종료 시 1, 2 입력")
    void handleGameChoiceTest() {
        GameInputImpl gameInput = new GameInputImpl();

        String input = gameInput.getReplayOrOverInput("1");
        String input2 = gameInput.getReplayOrOverInput("2");

        assertThat(input).isEqualTo("1");
        assertThat(input2).isEqualTo("2");
    }

    @Test
    @DisplayName("잘못된 입력_게임 종료 시 1, 2 이외의 숫자나 문자 입력")
    void handleGameChoiceTest2() {
        GameInputImpl gameInput = new GameInputImpl();

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () -> gameInput.getReplayOrOverInput("a"));
        IllegalArgumentException exception2 = assertThrows(
                IllegalArgumentException.class, () -> gameInput.getReplayOrOverInput("3"));
        IllegalArgumentException exception3 = assertThrows(
                IllegalArgumentException.class, () -> gameInput.getReplayOrOverInput("12"));

        assertThat(exception.getMessage()).isEqualTo(INVALID_FORMAT_INPUT2.getMsg());
        assertThat(exception2.getMessage()).isEqualTo(INVALID_FORMAT_INPUT2.getMsg());
        assertThat(exception3.getMessage()).isEqualTo(INVALID_FORMAT_INPUT2.getMsg());
    }
}