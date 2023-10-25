package baseball;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidationTest {

    InputValidation inputValidation = new InputValidation();

    @DisplayName("통합 테스트 - 올바른 input이 들어온 케이스, 공백까지는 인정")
    @Test
    void validateUserNumbers() {
        //given
        String input = "3 69";
        //when
        List<Integer> result = inputValidation.validateAndConvertUserNumbers(input);
        //then
        assertThat(result).isEqualTo(List.of(3, 6, 9));
    }

//    @DisplayName("다양한 에러 케이스 테스트")
//    @ParameterizedTest
//    @ValueSource(strings = {"12,", "1234", "102", "2a6", "339"})
//    public void validateErrorTest(String input) throws Exception {
//        //given
//
//        //when
//        List<Integer> result = inputValidation.validateAndConvertUserNumbers(input);
//        //then
////        System.out.println(input);
//        assertThatThrownBy(() -> inputValidation.validateAndConvertUserNumbers(input))
//                .isInstanceOf(IllegalArgumentException.class);
//    }

    @DisplayName("오류 검증 - 지정된 길이가 아니라면 (3개의 숫자를 입력해주세요.) 에러 메시지")
    @Test
    void validateLength() throws Exception {
        String input = "1234";

        assertThatThrownBy(() -> inputValidation.validateLength(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("3개의 숫자를 입력해주세요.");

    }

    @DisplayName("오류 검증 - 숫자로만 이루어져있지 않다면 (숫자만 입력해 주세요.) 에러 메시지")
    @Test
    void validateOnlyDigit() throws Exception {
        String input = "1a3";

        assertThatThrownBy(() -> inputValidation.validateOnlyDigit(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력해 주세요.");
    }

    @DisplayName("오류 검증 - 0이 포함되어 있다면 (1 ~ 9 사이의 숫자만 입력해주세요.) 에러 메시지")
    @Test
    void validateContainZero() throws Exception {
        String input = "190";

        assertThatThrownBy(() -> inputValidation.validateContainZero(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1 ~ 9 사이의 숫자만 입력해주세요.");
    }

    @DisplayName("오류 검증 - 1 혹은 2가 아니라면 (재시작은 1, 게임 종료는 2입니다.) 에러 메시지")
    @Test
    void validateSign() throws Exception {
        String input = "3";
        assertThatThrownBy(() -> inputValidation.validateSign(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("재시작은 1, 게임 종료는 2입니다.");
    }

    @DisplayName("오류 검증 - 재시작 / 종료 사인을 하나만 입력하지 않았다면 (하나의 숫자만 입력해 주세요) 에러 메시지")
    @Test
    void validateSignLength() throws Exception {
        String input = "12";

        assertThatThrownBy(() -> inputValidation.validateSignLength(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("하나의 숫자만 입력해 주세요.");
    }

    @DisplayName("오류 검증 - 중복된 수를 입력했다면 (중복된 수는 입력할 수 없습니다) 에러 메시지")
    @Test
    void validateDuplicateNumber() throws Exception {
        String input = "112";

        assertThatThrownBy(() -> inputValidation.validateDuplicateNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 수는 입력할 수 없습니다.");
    }
}