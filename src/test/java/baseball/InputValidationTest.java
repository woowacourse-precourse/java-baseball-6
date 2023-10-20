package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputValidationTest {

    @DisplayName("유저 input에 공백이 들어가 있는 경우의 테스트")
    @Test
    void containSpaceUserInputTest() {
        //given
        InputValidation inputValidation = new InputValidation();
        //when
        final String containSpaceUserInput = "12 4";
        //then
        assertThatThrownBy(() -> inputValidation.validateUserInput(containSpaceUserInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공백 없이 오직 숫자만 입력해주시기 바랍니다.");
    }
}