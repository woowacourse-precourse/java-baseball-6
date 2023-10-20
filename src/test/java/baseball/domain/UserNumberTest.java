package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class UserNumberTest {

    @DisplayName("올바르지 않은 숫자가 인자로 들어올 경우 예외가 발생한다.")
    @Test
    void setNumber() {
        // given
        List<Integer> numberList = List.of(1,2,10);
        UserNumber userNumber = new UserNumber();

        // when, then
        assertThatThrownBy(() -> userNumber.setNumber(numberList))
                .isInstanceOf(IllegalArgumentException.class);
    }

}