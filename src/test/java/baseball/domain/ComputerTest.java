package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import baseball.config.ComputerTestConfig;
import baseball.utils.NumberGenerator;
import baseball.utils.RandomNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Computer 클래스")
public class ComputerTest {

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class compareStrike_메소드는 extends ComputerTestConfig {

        @Nested
        @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
        class 같은_인덱스의_Player_숫자값과_일치하면 {
            @Test
            void true를_반환한다() {
                Player player = new Player("123");
                Computer computer = new TestComputer(List.of(1, 2, 6));

                assertEquals(computer.compareStrike(player, 0), true);
                assertEquals(computer.compareStrike(player, 1), true);
            }
        }

        @Nested
        @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
        class 같은_인덱스의_Player_숫자값과_일치하지_않으면 {
            @Test
            void false를_반환한다() {
                Player player = new Player("123");
                Computer computer = new TestComputer(List.of(3, 2, 6));

                assertEquals(computer.compareStrike(player, 0), false);
                assertEquals(computer.compareStrike(player, 2), false);
            }
        }
    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class compareBall_메소드는 extends ComputerTestConfig {

        @Nested
        @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
        class 같은_인덱스의_Player_숫자값과_일치하면 {
            @Test
            void false를_반환한다() {
                Player player = new Player("123");
                Computer computer = new TestComputer(List.of(1, 2, 6));

                assertEquals(computer.compareBall(player, 0), false);
                assertEquals(computer.compareBall(player, 1), false);
            }
        }

        @Nested
        @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
        class 다른_인덱스의_Player_숫자값과_일치하면 {
            @Test
            void true를_반환한다() {
                Player player = new Player("123");
                Computer computer = new TestComputer(List.of(3, 5, 1));

                assertEquals(computer.compareBall(player, 0), true);
                assertEquals(computer.compareBall(player, 2), true);
            }
        }

        @Nested
        @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
        class 해당_인덱스의_Player_숫자값을_포함하지_않으면 {
            @Test
            void false를_반환한다() {
                Player player = new Player("123");
                Computer computer = new TestComputer(List.of(4, 5, 6));

                assertEquals(computer.compareBall(player, 0), false);
                assertEquals(computer.compareBall(player, 1), false);
                assertEquals(computer.compareBall(player, 2), false);
            }
        }
    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class resetOrMaintain_메소드는 extends ComputerTestConfig {

        @Nested
        @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
        class GameState이_RETRY로_주어지면 {
            @Test
            void 새로운_Computer_인스턴스를_반환한다() {
                NumberGenerator numberGenerator = new RandomNumberGenerator();
                Computer computer = new Computer(numberGenerator);

                assertNotEquals(computer.resetOrMaintain(GameState.RETRY, numberGenerator), computer);
            }
        }

        @Nested
        @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
        class GameState이_RETRY_이외의_값으로_주어지면 {
            @Test
            void 기존의_Computer_인스턴스를_반환한다() {
                NumberGenerator numberGenerator = new RandomNumberGenerator();
                Computer computer = new Computer(numberGenerator);

                assertEquals(computer.resetOrMaintain(GameState.RUNNING, numberGenerator), computer);
            }
        }
    }
}
