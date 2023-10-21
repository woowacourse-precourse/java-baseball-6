package baseball;

import baseball.domain.GameRestartChecker;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameRestartCheckerTest {

    @Test
    @DisplayName("숫자가 아닌 경우 에러 발생")
    void 숫자아님_예외(){
        assertThrowException("문자열문자열");
    }

    @Test
    @DisplayName("1이나 2가 아닌 경우 에러 발생")
    void 일이나2아님_예외(){
        assertThrowException("33");
    }

    private static void assertThrowException(String restart) {
        GameRestartChecker checker = new GameRestartChecker();
        Assertions.assertThatThrownBy(() ->
                        checker.updateRestartYn(restart))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
