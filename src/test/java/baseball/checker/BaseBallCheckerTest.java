package baseball.checker;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("BaseBallChecker 테스트")
public class BaseBallCheckerTest {
    @Nested
    @DisplayName("사용자로부터 입력 받은 값에 따라서 결과를 반환한다")
    public class checkGameResultTest {
        private final static BaseBallChecker checker = new BaseBallChecker();
        private final String targetNumber = "123";
        private final String ballResult = "781";
        private final String strikeResult = "104";
        private final String ballAndStrikeResult = "132";

        @Test
        @DisplayName("결과 코드로 볼 코드를 반환한다 [ex) 10, 20, 30]")
        public void ballResultTest() {
            // when
            int resultCode = checker.checkGameResult(ballResult, targetNumber);

            // then
            assertThat(resultCode).isIn(10, 20, 30);
        }

        @Test
        @DisplayName("결과 코드로 스트라이크 코드를 반환한다 [ex) 1, 2, 3]")
        public void strikeResultTest() {
            // when
            int resultCode = checker.checkGameResult(strikeResult, targetNumber);

            // then
            assertThat(resultCode).isIn(1, 2, 3);

        }

        @Test
        @DisplayName("결과 코드로 볼과 스트라이크 코드를 반환한다 [ex) 11, 12, 21, 22]")
        public void ballAndStrikeResultTest() {
            // when
            int resultCode = checker.checkGameResult(ballAndStrikeResult, targetNumber);

            // then
            assertThat(resultCode).isIn(11, 12, 21, 22);
        }

        @Test
        @DisplayName("구해야하는 값을 찾는 데에 성공한다")
        public void successToFindTargetNumber() {
            // when
            int resultCode = checker.checkGameResult(targetNumber, targetNumber);

            // then
            assertThat(resultCode).isEqualTo(3);
        }
    }
}
