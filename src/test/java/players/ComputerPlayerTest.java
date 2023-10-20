package players;

import exceptions.InvalidNumberException;
import java.util.List;
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
