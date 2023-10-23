package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.*;

class InputValidationTest {

    @DisplayName("유저 input에 공백이 들어가 있는 경우의 테스트")
    @Test
    void containSpaceUserInputTest() {
        //given
        InputValidation inputValidation = new InputValidation();
        //when
        final String containSpaceUserInput = "12 4";
        //then
        assertThatThrownBy(() -> inputValidation.validateInputValue(containSpaceUserInput))
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
        assertThatThrownBy(() -> inputValidation.validateInputValue(containCommaUserInput))
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
        assertThatThrownBy(() -> inputValidation.validateInputValue(overLengthUserInput))
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
        assertThatThrownBy(() -> inputValidation.validateInputValue(lessLengthUserInput))
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
        assertThatThrownBy(() -> inputValidation.validateThreeEachNumber(duplicatedNumber))
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
        assertThatThrownBy(() -> inputValidation.validateThreeEachNumber(alphabetCharacterInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만을 입력해주시기 바랍니다.");
        assertThatThrownBy(() -> inputValidation.validateThreeEachNumber(koreanCharacterInput))
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
        assertThatThrownBy(() -> inputValidation.validateThreeEachNumber(zeroNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1 ~ 9 사이의 숫자만을 입력해주시기 바랍니다.");
    }

    @DisplayName("게임 진행시 입력하는 input에 대한 전체 유효성 검사 테스트")
    @Test
    void ValidateAllUserInput() {
        //given
        InputValidation inputValidation = new InputValidation();
        //when
        final String userInput = "437";
        final List<Integer> parsedUserInput = List.of(4, 3, 7);
        //then
        inputValidation.validatePlayerInput(userInput);
        assertThat(inputValidation.convertUserInput(userInput)).isEqualTo(parsedUserInput);
    }

    @DisplayName("유효한 input 값 정수 리스트로 변환하는 테스트")
    @Test
    void parseStringToIntegerListTest() {
        //given
        InputValidation inputValidation = new InputValidation();
        //when
        final String userInput = "437";
        //then
        assertThat(inputValidation.convertUserInput(userInput)).isEqualTo(List.of(4, 3, 7));
    }

//    @DisplayName("게임 성공시 유저가 게임을 계속 진행할지, 종료할지에 대한 요구 input에 영어가 포함되었을 때의 테스트")
//    @Test
//    void containAlphaCharacterInUserInputTest() {
//        //given
//        InputValidation inputValidation = new InputValidation();
//    }
//
    @Test
    void validateGameEndRequestInputTest() {
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
        assertThat(inputValidation.validateGameEndRequestInput(firstUserInput)).isEqualTo(1);
        assertThat(inputValidation.validateGameEndRequestInput(secondUserInput)).isEqualTo(2);
        assertThatThrownBy(() -> inputValidation.validateGameEndRequestInput(thirdUserInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1 혹은 2를 입력해주세요.");
        assertThatThrownBy(() -> inputValidation.validateGameEndRequestInput(forthUserInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자를 입력해주세요");
        assertThatThrownBy(() -> inputValidation.validateGameEndRequestInput(fifthUserInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자를 입력해주세요");
        assertThatThrownBy(() -> inputValidation.validateGameEndRequestInput(lastUserInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("한자리 숫자 입력해주세요.");
    }
}