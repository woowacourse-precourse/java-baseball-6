package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidationTest {
//기능별 분리를 안하니까 단위별 테스트가 어렵다!!!!!크악
    Validation validation = new Validation();

    @DisplayName("3개 이상의 글자가 들어왔을 경우 예외 발생 테스트")
    @Test
    void validateThreeNumbers() {
        assertThatThrownBy(() -> validation.validateThreeNumbers("1234"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("3개의 숫자만 입력해주세요.");
    }

    @Test
    void validateSign() {
    }
}