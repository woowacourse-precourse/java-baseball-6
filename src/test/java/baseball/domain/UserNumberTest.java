package baseball.domain;

import baseball.model.UserNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class UserNumberTest {

    @Test
    @DisplayName("사용자 숫자가 3자리가 아니라면 예외가 발생한다.")
    void testValidateUserNumberSize() {
        assertThatThrownBy(() -> new UserNumber(List.of(1, 2, 3, 4)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
