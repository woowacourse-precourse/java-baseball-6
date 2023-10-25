package baseball;

import baseball.domain.PlayerNumbersManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerNumbersManagerTest {

    @DisplayName("입력된 값이 null인 경우 exception 발생")
    @Test
    void 입력된_값_null_체크() {
        String inputString = null;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            PlayerNumbersManager.checkPlayerNumberAndCreate(inputString);
        });
    }

    @DisplayName("입력된 값이 숫자가 아니라면 exception 발생")
    @Test
    void 입력된_값_숫자인지_체크() {
        String inputString = "숫자";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            PlayerNumbersManager.checkPlayerNumberAndCreate(inputString);
        });
    }

    @DisplayName("입력된 값이 숫자지만 3자리의 숫자가 아닌 경우 exception 발생")
    @Test
    void 입력된_값_숫자_자릿수_체크() {
        String inputString = "12";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            PlayerNumbersManager.checkPlayerNumberAndCreate(inputString);
        });
    }

    @DisplayName("입력된 값 숫자의 범위가 설정한 범위가 아니라면 exception 발생")
    @Test
    void 입력된_값_숫자_범위_체크() {
        String inputString = "072";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            PlayerNumbersManager.checkPlayerNumberAndCreate(inputString);
        });
    }

    @DisplayName("입력된 값 숫자중 중복된 값이 있다면 exception 발생")
    @Test
    void 입력된_값_숫자_중복_체크() {
        String inputString = "112";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            PlayerNumbersManager.checkPlayerNumberAndCreate(inputString);
        });
    }
}
