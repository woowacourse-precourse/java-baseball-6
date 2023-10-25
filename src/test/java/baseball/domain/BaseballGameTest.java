package baseball.domain;

import baseball.config.ComputerTestConfig;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("BaseballGame 클래스")
public class BaseballGameTest {

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class compare_메소드는 extends ComputerTestConfig {
        private static Stream<Arguments> providePlayerAndComputerNumbers() {
            return Stream.of(
                    Arguments.of("132", List.of(1, 2, 3), 2, 1),
                    Arguments.of("123", List.of(1, 2, 3), 0, 3),
                    Arguments.of("312", List.of(1, 2, 3), 3, 0)
            );
        }

        @ParameterizedTest
        @MethodSource("providePlayerAndComputerNumbers")
        void Player와_Computer의_숫자를_비교해_Baseball_객체를_생성한다(
                String playerNumbers, List<Integer> computerNumbers, int ballCnt, int strikeCnt
        ) {
            Player player = new Player(playerNumbers);
            Computer computer = new TestComputer(computerNumbers);
            BaseballGame baseballGame = new BaseballGame();
            baseballGame.compare(computer, player);

            Assertions.assertEquals(baseballGame.getBaseball(), new Baseball(ballCnt, strikeCnt));
        }
    }
}
