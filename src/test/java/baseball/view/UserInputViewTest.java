package baseball.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.util.common.Common;
import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserInputViewTest {
    private static final String REGEXP_ONLY_NUM = "\\d+";
    private static final String VALID_LENGTH = "숫자의 길이가 " + Common.NUM_LENGTH + "와 다릅니다.";
    private static final String VALID_IS_NUM = "숫자가 아닌 문자가 입력 되었습니다.";
    private static final String VALID_IS_DUPLICATE = "중복된 값이 들어갔습니다.";

    private static final String VALID_IS_NULL = "빈 값이 들어갔습니다.";
    private final UserInputView userInputView = new UserInputView();


    @Test
    void 빈숫자를_전달하면_예외처리() {
        systemIn(" ");
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
                userInputView::inputUserNumber
                , "공백이 전달되었습니다.");

        assertEquals(VALID_IS_NULL, exception.getMessage());

        backupSystem();
    }

    @Test
    void 빈값을_전달하면_예외처리() {
        systemIn("");
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
                userInputView::inputUserNumber
                , "빈값이 전달되었습니다.");

        assertEquals(VALID_IS_NULL, exception.getMessage());
        backupSystem();
    }

    @Test
    void 문자를_전달하면_예외처리() {
        systemIn("ab1");
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
                userInputView::inputUserNumber
                , "문자가 입력되었습니다.");

        assertEquals(VALID_IS_NUM, exception.getMessage());
        backupSystem();
    }

    @Test
    void 중복된_문자_전달하면_예외처리() {
        systemIn("113");

        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
                userInputView::inputUserNumber
                , "중복된 숫자가 입력되었습니다.");

        assertEquals(VALID_IS_DUPLICATE, exception.getMessage());
        backupSystem();
    }

    @Test
    void 정상적인_문자_입력() {
        systemIn("123");
        Assertions.assertDoesNotThrow(userInputView::inputUserNumber);
        backupSystem();
    }


    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }


    void backupSystem() {
        Console.close();
    }

}