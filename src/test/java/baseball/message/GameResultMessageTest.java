package baseball.message;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static baseball.message.GameResultMessage.*;
import static org.assertj.core.api.Assertions.*;

@DisplayName("GameResultMessage 테스트")
public class GameResultMessageTest {
    @Nested
    @DisplayName("상태 코드에 따라서 결과를 출력한다")
    public class getMessageByCodeTest {
        private final static int notMatchedCode = NOT_MATCHED.getCode();
        private final static int onlyBallCode = BALL_1.getCode();
        private final static int onlyStrikeCode = STRIKE_1.getCode();
        private final static int ballAndStrikeCode = BALL_1.getCode() + STRIKE_1.getCode();

        @Test
        @DisplayName("유효한 숫자가 포함되지 않을 경우, '낫싱'을 출력한다")
        public void printNotMatchedMessage() {
            // when
            String message = getMessageByCode(notMatchedCode);

            // then
            assertThat(message).isEqualTo(NOT_MATCHED.getMessage());
        }

        @Test
        @DisplayName("유효한 숫자가 포함되어 있지만, 자리는 일치하지 않는 경우 '볼'을 출력한다")
        public void printOnlyBallMessage() {
            // when
            String message = getMessageByCode(onlyBallCode);

            // then
            assertThat(message).isEqualTo(BALL_1.getMessage());
        }

        @Test
        @DisplayName("유효한 숫자가 자리까지 일치하는 경우, '스트라이크'를 출력한다")
        public void printOnlyStrikeMessage() {
            // when
            String message = getMessageByCode(onlyStrikeCode);

            // then
            assertThat(message).isEqualTo(STRIKE_1.getMessage());
        }

        @Test
        @DisplayName("유효한 숫자가 포함되어 있고, 자리가 일치하는 숫자가 존재한다면 '볼'과 '스트라이크'를 출력한다")
        public void printBallAndStrikeMessage() {
            // when
            String message = getMessageByCode(ballAndStrikeCode);

            // then
            assertThat(message).isEqualTo(BALL_1.getMessage() + " " + STRIKE_1.getMessage());
        }
    }
}