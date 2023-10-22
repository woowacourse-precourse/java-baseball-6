package baseball;

import baseball.validation.GameValidation;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationTest extends NsTest {

    @ParameterizedTest
    @ValueSource(strings = {"1234","12","1 3","12a","222","012",""})
    void 사용자_게임_입력_값_예외_테스트(String input_value){
        assertThatThrownBy(()->GameValidation.verifyForRetryValue(input_value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[Err]");
    }

    @ParameterizedTest
    @ValueSource(strings = {"3","12",""," ","a"})
    void 사용자_게임_재도전_여부_입력_값_예외_테스트(String input_retry){
        assertThatThrownBy(()->GameValidation.verifyForRetryValue(input_retry))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[Err]");
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
