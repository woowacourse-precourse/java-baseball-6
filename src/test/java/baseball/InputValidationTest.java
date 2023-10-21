package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class InputValidationTest {

    InputValidation inputValidation = new InputValidation();

    @Test
    void validateUserNumbers() {
    }

    @DisplayName("오류 검증 - 지정된 길이가 아니라면 (3개의 숫자만 입력해주세요.) 에러 메시지")
    @Test
    void validateLength() {
        String input = "1234";
        assertThatThrownBy(() -> inputValidation.validateLength(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("3개의 숫자만 입력해주세요.");

    }

    @DisplayName("오류 검증 - 숫자로만 이루어져있지 않다면 (숫자만 입력해 주세요.) 에러 메시지")
    @Test
    void validateOnlyDigit() {
        String input = "1a3";
        assertThatThrownBy(() -> inputValidation.validateOnlyDigit(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력해 주세요.");
    }

    @DisplayName("오류 검증 - 0이 포함되어 있다면 (1 ~ 9 사이의 숫자만 입력해주세요.) 에러 메시지")
    @Test
    void validateContainZero() {
        String input = "190";
        assertThatThrownBy(() -> inputValidation.validateContainZero(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1 ~ 9 사이의 숫자만 입력해주세요.");
    }

    @DisplayName("변환 - String을 List<Integer>로 변환하는 테스트")
    @Test
    void convertStrToIntegerList() {
        //given
        String input = "369";
        //when
        List<Integer> result = inputValidation.convertStrToIntegerList(input);
        //then
        assertThat(result).isEqualTo(List.of(3,6,9));
    }

    @DisplayName("오류 검증 - 1 혹은 2가 아니라면 (재시작은 1, 게임 종료는 2입니다.) 에러 메시지")
    @Test
    void validateSign() {
        String input = "3";
        assertThatThrownBy(() -> inputValidation.validateSign(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("재시작은 1, 게임 종료는 2입니다.");
    }

    @DisplayName("오류 검증 - 재시작 / 종료 사인을 하나만 입력하지 않았다면 (하나의 숫자만 입력해 주세요) 에러 메시지")
    @Test
    void validateSignLength() {
        String input = "1 2";
        assertThatThrownBy(() -> inputValidation.validateSignLength(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("재시작은 1, 게임 종료는 2입니다.");
    }
}