package players;

import exceptions.InvalidNumberException;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComputerPlayerTest {

    @Test
    void 서로_다른_1부터_9까지의_숫자_세_개_생성() {
        // given
        ComputerPlayer computer = new ComputerPlayer();
        // when
        int[] randomNumber = computer.createNumber();
        // then
        Assertions.assertDoesNotThrow(() -> validateNumber(randomNumber));
    }

    @Test
    void highRevolutionTest() {
        for(int i = 0; i < 100; i++) {
            // given
            ComputerPlayer computer = new ComputerPlayer();
            // when
            int[] randomNumber = computer.createNumber();
            // then
            try {
                validateNumber(randomNumber);
            } catch (InvalidNumberException e) {
                System.out.print("\033[34m");
                Arrays.stream(randomNumber).forEach((n) -> System.out.print(n + " "));
                System.out.print("\033[0m");
                Assertions.fail();
            }
        }
    }

    void validateNumber(int[] number) throws InvalidNumberException {
        if (number.length != 3)
            throw new InvalidNumberException();
        int[] countOf = new int[10];
        for (int i = 0; i < 3; i++) {
            if (number[i] == 0)
                throw new InvalidNumberException();
            if (++countOf[number[i]] > 1)
                throw new InvalidNumberException();
        }
    }
}
