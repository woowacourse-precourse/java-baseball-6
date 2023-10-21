package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @DisplayName("유저 input 안에 중복 값이 있는 경우의 테스트")
    @Test
    void duplicatedNumberInUserInputTest() {
        //given
        InputValidation inputValidation = new InputValidation();
        //when
        final String duplicatedNumber = "119";
        //then
        assertThatThrownBy(() -> inputValidation.validateInputNumber(duplicatedNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자를 중복하지 않고 입력해주시기 바랍니다.");
    }

    @DisplayName("유저 input 안에 숫자가 아닌 문자가 들어가 있는 경우의 테스트")
    @Test
    void notDigitCharacterInUserInputTest() {
        //given
        InputValidation inputValidation = new InputValidation();
        //when
        final String alphabetCharacterInput = "1c9";
        final String koreanCharacterInput = "2ㅍ1";
        //then
        assertThatThrownBy(() -> inputValidation.validateInputNumber(alphabetCharacterInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만을 입력해주시기 바랍니다.");
        assertThatThrownBy(() -> inputValidation.validateInputNumber(koreanCharacterInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만을 입력해주시기 바랍니다.");
    }

    @DisplayName("유저 input 안에 '0'이 들어가 있는 경우의 테스트")
    @Test
    void zeroNumberInUserInputTest() {
        //given
        InputValidation inputValidation = new InputValidation();
        //when
        final String zeroNumber = "140";
        //then
        assertThatThrownBy(() -> inputValidation.validateInputNumber(zeroNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1 ~ 9 사이의 숫자만을 입력해주시기 바랍니다.");
    }

    @DisplayName("유효한 input 값 정수 리스트로 변환하는 테스트")
    @Test
    void parseStringToIntegerListTest() {
        //given
        InputValidation inputValidation = new InputValidation();
        //when
        final String userInput = "437";
        //then
        assertThat(inputValidation.userInputToList(userInput)).isEqualTo(List.of(4, 3, 7));
    }
}