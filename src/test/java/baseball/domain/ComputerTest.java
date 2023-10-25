package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.config.ComputerTestConfig;
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
    class compareSameIndexNumber_메소드는 extends ComputerTestConfig {
        @Test
        void 같은_인덱스의_Player_숫자값과_일치하는_개수를_반환한다() {
            Player player = new Player("123");
            Computer computer = new TestComputer(List.of(1, 2, 6));

            assertEquals(computer.compareSameIndexNumber(player), 2);
        }
    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class compareContainNumber_메소드는 extends ComputerTestConfig {

        @Test
        void 포함하고_있는_Player_숫자_개수를_반환한다() {
            Player player = new Player("123");
            Computer computer = new TestComputer(List.of(3, 2, 4));

            assertEquals(computer.compareContainNumber(player), 2);
        }
    }
}
