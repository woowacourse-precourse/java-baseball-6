package baseball.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserNumberTest {
    @Test
    @DisplayName("입력 값 3자리 보다 큰 경우 IllegalArgumentException 확인")
    void checkInputSizeOverThree() {
        assertThatThrownBy(() -> new UserNumber("4123")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 값 3자리 보다 작은 경우 IllegalArgumentException 확인")
    void checkInputSizeUnderThree() {
        assertThatThrownBy(() -> new UserNumber("41")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 값 같은 수 존재 시 IllegalArgumentException 확인")
    void checkSameNumber() {
        assertThatThrownBy(() -> new UserNumber("442")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 값 문자 입력 시 IllegalArgumentException 확인")
    void checkNotNUmber() {
        assertThatThrownBy(() -> new UserNumber("~@b")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정상 입력 시 예외 없는지 확인")
    void checkLegalArgument() {
        assertThatCode(() -> new UserNumber("345")).doesNotThrowAnyException();
    }
}