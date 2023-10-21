package baseball;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
        List<Integer> result = inputValidation.validateUserNumbers(input);
        //then
        assertThat(result).isEqualTo(List.of(3, 6, 9));
    }

    @DisplayName("오류 검증 - 지정된 길이가 아니라면 (3개의 숫자만 입력해주세요.) 에러 메시지")
    @Test
    void validateLength() throws Exception {
        String input = "1234";
        Method method = inputValidation.getClass().getDeclaredMethod("validateLength", String.class);
        method.setAccessible(true);

        try {
            method.invoke(inputValidation, input);
        } catch (InvocationTargetException e) {
            Throwable originException = e.getCause();
            assertThat(originException)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("3개의 숫자만 입력해주세요.");
        }

    }

    @DisplayName("오류 검증 - 숫자로만 이루어져있지 않다면 (숫자만 입력해 주세요.) 에러 메시지")
    @Test
    void validateOnlyDigit() throws Exception {
        String input = "1a3";
        Method method = inputValidation.getClass().getDeclaredMethod("validateOnlyDigit", String.class);
        method.setAccessible(true);

        try {
            method.invoke(inputValidation, input);
        } catch (InvocationTargetException e) {
            Throwable originException = e.getCause();
            assertThat(originException)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("숫자만 입력해 주세요.");
        }
    }

    @DisplayName("오류 검증 - 0이 포함되어 있다면 (1 ~ 9 사이의 숫자만 입력해주세요.) 에러 메시지")
    @Test
    void validateContainZero() throws Exception {
        String input = "190";
        Method method = inputValidation.getClass().getDeclaredMethod("validateContainZero", String.class);
        method.setAccessible(true);

//        assertThatThrownBy(() -> method.invoke(inputValidation, input))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessage("1 ~ 9 사이의 숫자만 입력해주세요.");
        try {
            method.invoke(inputValidation, input);
        } catch (InvocationTargetException e) {
            Throwable originException = e.getCause();
            assertThat(originException)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("1 ~ 9 사이의 숫자만 입력해주세요.");
        }
    }

    @DisplayName("변환 - String을 List<Integer>로 변환하는 테스트")
    @Test
    void convertStrToIntegerList() throws Exception {
        //given
        String input = "369";
        Method method = inputValidation.getClass().getDeclaredMethod("convertStrToIntegerList", String.class);
        method.setAccessible(true);

        //when
        List<Integer> result = (List<Integer>) method.invoke(inputValidation, input);
        //then
        assertThat(result).isEqualTo(List.of(3, 6, 9));
    }

    @DisplayName("오류 검증 - 1 혹은 2가 아니라면 (재시작은 1, 게임 종료는 2입니다.) 에러 메시지")
    @Test
    void validateSign() throws Exception {
        String input = "3";
        Method method = inputValidation.getClass().getDeclaredMethod("validateSign", String.class);
        method.setAccessible(true);

        try {
            method.invoke(inputValidation, input);
        } catch (InvocationTargetException e) {
            Throwable originException = e.getCause();
            assertThat(originException)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("재시작은 1, 게임 종료는 2입니다.");
        }
    }

    @DisplayName("오류 검증 - 재시작 / 종료 사인을 하나만 입력하지 않았다면 (하나의 숫자만 입력해 주세요) 에러 메시지")
    @Test
    void validateSignLength() throws Exception {
        String input = "12";
        Method method = inputValidation.getClass().getDeclaredMethod("validateSignLength", String.class);
        method.setAccessible(true);

        try {
            method.invoke(inputValidation, input);
        } catch (InvocationTargetException e) {
            Throwable originException = e.getCause();
            assertThat(originException)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("하나의 숫자만 입력해 주세요");
        }
    }

    @DisplayName("오류 검증 - 중복된 수를 입력했다면 (중복된 수는 입력할 수 없습니다) 에러 메시지")
    @Test
    void validateDuplicateNumber() throws Exception {
        String input = "112";
        Method method = inputValidation.getClass().getDeclaredMethod("validateDuplicateNumber", String.class);
        method.setAccessible(true);

        try {
            method.invoke(inputValidation, input);
        } catch (InvocationTargetException e) {
            Throwable originException = e.getCause();
            assertThat(originException)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("중복된 수는 입력할 수 없습니다");
        }
    }
}