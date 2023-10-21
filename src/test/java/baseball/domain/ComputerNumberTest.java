package baseball.domain;

import baseball.model.ComputerNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ComputerNumberTest {

    @Test
    @DisplayName("컴퓨터 숫자가 3자리가 아니라면 예외가 발생한다.")
    void testValidateComputerNumberSize() {
        assertThatThrownBy(() -> new ComputerNumber(List.of(1, 2, 3, 4)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
