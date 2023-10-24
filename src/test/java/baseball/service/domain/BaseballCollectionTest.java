package baseball.service.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BaseballCollectionTest {

    @Nested
    class ComputerBaseballCreateTest {
        @Test
        @DisplayName("[성공 테스트] 컴퓨터 공 생성")
        void computerCreateTest() {
            // given
            int totalTestCase = 10000;
            // when, then
            for (int testCase = 0; testCase < totalTestCase; testCase++) {
                assertThatCode(() -> BaseballCollection.ofComputerBaseball(new RandomNumberGenerator()))
                        .doesNotThrowAnyException();
            }
        }
    }

    @Nested
    class PlayerBaseballCreateTest {

        @Test
        @DisplayName("[성공 테스트] 서로 다른 3가지 수")
        void correctPlayerBallInputTest() {
            // given
            List<String> playerBalls = List.of("123", "234", "345", "456", "567", "678", "789", "158", "259", "325");
            // when, then
            for (String playerBall : playerBalls) {
                assertThatCode(() -> BaseballCollection.ofPlayerBaseball(playerBall))
                        .doesNotThrowAnyException();
            }
        }

        @Test
        @DisplayName("[실패 테스트] 서로 다른 3자리 수지만, 0을 포함")
        void wrongTest1() {
            // given
            List<String> playerBalls = List.of("120", "204", "015");
            // when, then
            for (String playerBall : playerBalls) {
                assertThatThrownBy(() -> BaseballCollection.ofPlayerBaseball(playerBall))
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }

        @Test
        @DisplayName("[실패 테스트] 3자리 수지만, 중복된 숫자")
        void wrongTest4() {
            // given
            List<String> playerBalls = List.of("111",   // 3개 모두 중복
                    "112",  // 1,2번째 중복
                    "188",  // 2,3번째 중복
                    "959"); // 1,3번째 중복
            // when, then
            for (String playerBall : playerBalls) {
                assertThatThrownBy(() -> BaseballCollection.ofPlayerBaseball(playerBall))
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }

        @Test
        @DisplayName("[실패 테스트] 3자리 수가 아님")
        void wrongTest2() {
            // given
            List<String> playerBalls = List.of("7", "12", "1243", "79283465");
            // when, then
            for (String playerBall : playerBalls) {
                assertThatThrownBy(() -> BaseballCollection.ofPlayerBaseball(playerBall))
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }

        @Test
        @DisplayName("[실패 테스트] 숫자가 아님")
        void wrongTest3() {
            // given
            List<String> playerBalls = List.of("12ㄱ", "1ㄱ8", "r42", // 문자 혼합
                    "홍길동", "red",   // 순수 문자
                    "\n", "\n1", "7\n", // 이스케이프
                    "", " ", " 1", "1 ");   // 공백
            // when, then
            for (String playerBall : playerBalls) {
                assertThatThrownBy(() -> BaseballCollection.ofPlayerBaseball(playerBall))
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }
    }
}
