package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.config.ComputerTestConfig.TestComputer;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("Computer 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class ComputerTest {

    @Test
    void countSameIndexNumber_메소드는_같은_인덱스의_Player_숫자값과_일치하는_개수를_반환한다() {
        Player player = new Player("123");
        Computer computer = new TestComputer(List.of(1, 2, 6));

        assertEquals(computer.countSameIndexNumber(player), 2);
    }

    @Test
    void countContainNumber_메소드는_포함하고_있는_Player_숫자_개수를_반환한다() {
        Player player = new Player("123");
        Computer computer = new TestComputer(List.of(3, 2, 4));

        assertEquals(computer.countContainNumber(player), 2);
    }
}
