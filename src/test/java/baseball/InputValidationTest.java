package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.*;
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

    @DisplayName("유저 input에 ','가 들어가 있는 경우의 테스트")
    @Test
    void containCommaUserInputTest() {
        //given
        InputValidation inputValidation = new InputValidation();
        //when
        final String containCommaUserInput = "2,87";
        //then
        assertThatThrownBy(() -> inputValidation.validateUserInput(containCommaUserInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("콤마 없이 오직 숫자만 입력해주시기 바랍니다.");
    }

    @DisplayName("유저 input의 길이가 3을 초과하는 경우의 테스트")
    @Test
    void overLengthUserInputTest() {
        //given
        InputValidation inputValidation = new InputValidation();
        //when
        final String overLengthUserInput = "1792";
        //then
        assertThatThrownBy(() -> inputValidation.validateUserInput(overLengthUserInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("3개의 숫자만을 입력해주시기 바랍니다.");
    }

    @DisplayName("유저 input의 길이가 3 미만인 경우의 테스트")
    @Test
    void lessLengthUserInputTest() {
        //given
        InputValidation inputValidation = new InputValidation();
        //when
        final String lessLengthUserInput = "79";
        //then
        assertThatThrownBy(() -> inputValidation.validateUserInput(lessLengthUserInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("3개의 숫자만을 입력해주시기 바랍니다.");
    }
}