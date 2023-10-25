package baseball.model.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.model.service.Validator;
import baseball.model.service.ValidatorImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RestartTest {
    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = new ValidatorImp();
    }

    @Test
    @DisplayName("사용자가 재시작을 위해 입력한 수를 검사한 후, 리턴합니다.")
    void 사용자_재시작_숫자_입력() {
        String option = "1";
        Restart restart = Restart.of(option, validator);
        Integer restartNumbers = restart.getRestartOption();
        assertEquals(Integer.parseInt(option), restartNumbers);
    }
}
