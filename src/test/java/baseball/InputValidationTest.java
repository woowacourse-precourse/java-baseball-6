package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.*;

class InputValidationTest {

    @DisplayName("유저 input에 공백이 들어가 있는 경우의 테스트")
    @Test
    void containSpacePlayerInputTest() {
        //given
        InputValidation inputValidation = new InputValidation();
        //when
        final String containSpacePlayerInput = "12 4";
        //then
        assertThatThrownBy(() -> inputValidation.validateInputValue(containSpacePlayerInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공백 없이 오직 숫자만 입력해주시기 바랍니다.");
    }

    @DisplayName("유저 input에 ','가 들어가 있는 경우의 테스트")
    @Test
    void containCommaPlayerInputTest() {
        //given
        InputValidation inputValidation = new InputValidation();
        //when
        final String containCommaPlayerInput = "2,87";
        //then
        assertThatThrownBy(() -> inputValidation.validateInputValue(containCommaPlayerInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("콤마 없이 오직 숫자만 입력해주시기 바랍니다.");
    }

    @DisplayName("유저 input의 길이가 3을 초과하는 경우의 테스트")
    @Test
    void overLengthPlayerInputTest() {
        //given
        InputValidation inputValidation = new InputValidation();
        //when
        final String overLengthPlayerInput = "1792";
        //then
        assertThatThrownBy(() -> inputValidation.validateInputValue(overLengthPlayerInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("3개의 숫자만을 입력해주시기 바랍니다.");
    }

    @DisplayName("유저 input의 길이가 3 미만인 경우의 테스트")
    @Test
    void lessLengthPlayerInputTest() {
        //given
        InputValidation inputValidation = new InputValidation();
        //when
        final String lessLengthPlayerInput = "79";
        //then
        assertThatThrownBy(() -> inputValidation.validateInputValue(lessLengthPlayerInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("3개의 숫자만을 입력해주시기 바랍니다.");
    }

    @DisplayName("유저 input 안에 중복 값이 있는 경우의 테스트")
    @Test
    void duplicatedNumberInPlayerInputTest() {
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
    void notDigitCharacterInPlayerInputTest() {
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
    void zeroNumberInPlayerInputTest() {
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
    void ValidateAllPlayerInput() {
        //given
        InputValidation inputValidation = new InputValidation();
        //when
        final String playerInput = "437";
        final List<Integer> convertedPlayerInput = List.of(4, 3, 7);
        //then
        inputValidation.validatePlayerInput(playerInput);
        assertThat(inputValidation.convertPlayerInput(playerInput)).isEqualTo(convertedPlayerInput);
    }

    @DisplayName("유효한 input 값 정수 리스트로 변환하는 테스트")
    @Test
    void parseStringToIntegerListTest() {
        //given
        InputValidation inputValidation = new InputValidation();
        //when
        final String playerInput = "437";
        //then
        assertThat(inputValidation.convertPlayerInput(playerInput)).isEqualTo(List.of(4, 3, 7));
    }

    @DisplayName("게임 성공시 유저가 게임을 계속 진행할지, 종료할지에 대한 요구 input에 영어가 포함되었을 때의 테스트")
    @Test
    void containAlphaCharacterInPlayerInputTest() {
        //given
        InputValidation inputValidation = new InputValidation();
        //when
        final String alphabet = "a";
        //then
        assertThatThrownBy(() -> inputValidation.validateGameEndRequestInput(alphabet))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자를 입력해주세요");
    }

    @DisplayName("게임 성공시 유저가 게임을 계속 진행할지, 종료할지에 대한 요구 input에 한글이 포함되었을 때의 테스트")
    @Test
    void containKoreanCharacterInPlayerInputTest() {
        //given
        InputValidation inputValidation = new InputValidation();
        //when
        final String korean = "a";
        //then
        assertThatThrownBy(() -> inputValidation.validateGameEndRequestInput(korean))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자를 입력해주세요");
    }

    @DisplayName("게임 성공시 유저가 게임을 계속 진행할지, 종료할지에 대한 요구 input에 1, 2가 아닌 숫자가 포함되었을 때의 테스트")
    @Test
    void containOverOrLessValueInPlayerInputTest() {
        //given
        InputValidation inputValidation = new InputValidation();
        //when
        final String overValue = "4";
        final String lessValue = "0";
        //then
        assertThatThrownBy(() -> inputValidation.validateGameEndRequestInput(overValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1 혹은 2를 입력해주세요.");
        assertThatThrownBy(() -> inputValidation.validateGameEndRequestInput(lessValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1 혹은 2를 입력해주세요.");
    }

    @DisplayName("게임 성공시 유저가 게임을 계속 진행할지, 종료할지에 대한 요구 input의 길이가 1을 초과할때의 테스트")
    @Test
    void containLongLengthInPlayerInput() {
        //given
        InputValidation inputValidation = new InputValidation();
        //when
        final String longLength = "4234";
        //then
        assertThatThrownBy(() -> inputValidation.validateGameEndRequestInput(longLength))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("한자리 숫자 입력해주세요.");
    }

    @DisplayName("게임 성공시 유저가 게임을 계속 진행할지, 종료할지에 대한 요구 성공 테스트")
    @Test
    void validateGameEndRequestInputTest() {
        //given
        InputValidation inputValidation = new InputValidation();
        //when
        final String gameRetry = "1";
        final String gameEnd = "2";
        //then
        assertThat(inputValidation.validateGameEndRequestInput(gameRetry)).isEqualTo(1);
        assertThat(inputValidation.validateGameEndRequestInput(gameEnd)).isEqualTo(2);
    }
}