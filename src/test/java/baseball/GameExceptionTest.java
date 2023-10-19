package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GameExceptionTest {
    GameException exception = new GameException();

    @Test
    void 입력_숫자_길이_예외_테스트1() {
        String number = "";
        Assertions.assertThatThrownBy(() -> {
            exception.playerNumberLengthException(number);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력_숫자_길이_예외_테스트2() {
        String number = "1234";
        Assertions.assertThatThrownBy(() -> {
            exception.playerNumberLengthException(number);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력_숫자_범위_예외_테스트() {
        String number = "012";
        Assertions.assertThatThrownBy(() -> {
            exception.playerNumberTypeException(number);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력_숫자_타입_예외_테스트() {
        String number = "12a";
        Assertions.assertThatThrownBy(() -> {
            exception.playerNumberTypeException(number);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력_숫자_중복_예외_테스트() {
        int[] numbers = new int[]{1, 2, 3};

        Assertions.assertThatThrownBy(() -> {
            exception.playerNumberDuplicateException(numbers, '1');
        }).isInstanceOf(IllegalArgumentException.class);
    }
}