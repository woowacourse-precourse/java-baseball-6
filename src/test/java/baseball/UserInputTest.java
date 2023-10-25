package baseball;

import baseball.controller.UserInputValidator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class UserInputTest {
    UserInputValidator userInputValidator = new UserInputValidator();

    @Test
    void 유저_정답_입력_정상() {
        String userInputString = "123";
        List<Integer> userInputNumbers = Arrays.asList(1, 2, 3);
        assertThat(userInputValidator.userInputNumbersValidate(userInputValidator.validateUserInputString(userInputString)))
                .isEqualTo(userInputNumbers);
    }

    @Test
    void 유저_정답_입력_띄어쓰기_정상() {
        String userInputString = "1 2 3";
        List<Integer> userInputNumbers = Arrays.asList(1, 2, 3);
        assertThat(userInputValidator.userInputNumbersValidate(userInputValidator.validateUserInputString(userInputString)))
                .isEqualTo(userInputNumbers);
    }

    @Test
    void 유저_정답_입력_null_오류() {
        String userInputString = null;
        assertThatThrownBy(() -> userInputValidator.validateUserInputString(userInputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("null은 입력할 수 없습니다.");
    }

    @Test
    void 유저_정답_입력_세자리_미만_오류() {
        String userInputString = "12";
        assertThatThrownBy(() -> userInputValidator.userInputNumbersValidate(userInputValidator.validateUserInputString(userInputString)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("세 자리의 숫자를 입력해주세요.");
    }

    @Test
    void 유저_정답_입력_세자리_초과_오류() {
        String userInputString = "1234";
        assertThatThrownBy(() -> userInputValidator.userInputNumbersValidate(userInputValidator.validateUserInputString(userInputString)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("세 자리의 숫자를 입력해주세요.");
    }

    @Test
    void 유저_정답_입력_범위_초과_문자_오류() {
        String userInputString = "12a";
        assertThatThrownBy(() -> userInputValidator.userInputNumbersValidate(userInputValidator.validateUserInputString(userInputString)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("한 자리는 1에서 9까지의 숫자만 입력할 수 있습니다.");
    }

    @Test
    void 유저_정답_입력_범위_초과_숫자_오류() {
        String userInputString = "012";
        assertThatThrownBy(() -> userInputValidator.userInputNumbersValidate(userInputValidator.validateUserInputString(userInputString)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("한 자리는 1에서 9까지의 숫자만 입력할 수 있습니다.");
    }

    @Test
    void 유저_정답_입력_중복_오류() {
        String userInputString = "112";
        assertThatThrownBy(() -> userInputValidator.userInputNumbersValidate(userInputValidator.validateUserInputString(userInputString)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("세 자리 모두 서로 다른 숫자를 입력해주세요.");
    }

    @Test
    void 유저_재시작_입력_정상() {
        String userInputString = "1";
        assertThat(userInputValidator.userInputRestartOrExitValidate(userInputString))
                .isEqualTo(1);
    }

    @Test
    void 유저_재시작_입력_범위초과_오류() {
        String userInputString = "3";
        assertThatThrownBy(() -> userInputValidator.userInputRestartOrExitValidate(userInputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 또는 2를 입력해주세요.");
    }

    @Test
    void 유저_게임종료_입력_정상() {
        String userInputString = "2";
        assertThat(userInputValidator.userInputRestartOrExitValidate(userInputString))
                .isEqualTo(2);
    }
}
