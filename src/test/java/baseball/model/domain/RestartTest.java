package baseball.model.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RestartTest {
    @Test
    @DisplayName("사용자가 입력한 수를 검사한 후, 리턴합니다.")
    void 사용자입력수리턴() {
        String option = "1";
        Restart restart = new Restart(option);

        Integer restartNumbers = restart.getRestartOption();

        assertEquals(1, restartNumbers);
    }
}
