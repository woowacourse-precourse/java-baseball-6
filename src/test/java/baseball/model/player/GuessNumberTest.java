package baseball.model.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GuessNumberTest {

    @Test
    @DisplayName("1-9사이의 숫자를 입력 시 number 필드에 입력한 값으로 생성된다.")
    void validNumber_constructor_test() {
        GuessNumber guessNumber = new GuessNumber(5);
        assertEquals(5, guessNumber.getNumber());
    }

    @Test
    @DisplayName("1-9사이의 숫자를 입력하지 않으면 예외가 발생한다.")
    void invalidNumber_constructor_test() {
        assertThrows(IllegalArgumentException.class, () -> {
            new GuessNumber(10);
        });
    }
}