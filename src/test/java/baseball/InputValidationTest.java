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

    @DisplayName("게임 성공시 유저가 게임을 진행할지, 종료할지에 대한 요구 input의 유효성을 판단하는 테스트")
    @Test
    void validateNewGameOrEndUserInputTest() {
        //given
        InputValidation inputValidation = new InputValidation();
        //when
        final String firstUserInput = "1";
        final String secondUserInput = "2";
        final String thirdUserInput = "3";
        final String forthUserInput = "c";
        final String fifthUserInput = "ㅁ";
        final String lastUserInput = "123";
        //then
        assertThat(inputValidation.validateNewGameRequest(firstUserInput)).isEqualTo(1);
        assertThat(inputValidation.validateNewGameRequest(secondUserInput)).isEqualTo(2);
        assertThatThrownBy(() -> inputValidation.validateNewGameRequest(thirdUserInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1 혹은 2를 입력해주세요.");
        assertThatThrownBy(() -> inputValidation.validateNewGameRequest(forthUserInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자를 입력해주세요");
        assertThatThrownBy(() -> inputValidation.validateNewGameRequest(fifthUserInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자를 입력해주세요");
        assertThatThrownBy(() -> inputValidation.validateNewGameRequest(lastUserInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("한자리 숫자 입력해주세요.");
    }
}