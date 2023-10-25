package baseball.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.model.player.Computer;
import baseball.ui.ConsoleOutput;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ComputerTest {

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5})
    void 컴퓨터는_게임_볼_개수_규칙만큼_볼을_생성함(int numberBalls) {
        // given
        Computer computer = new Computer(new ConsoleOutput());

        // when
        computer.generatePlayerNumber(numberBalls);

        // then
        assertEquals(numberBalls, computer.getNumbers().size());
    }

}