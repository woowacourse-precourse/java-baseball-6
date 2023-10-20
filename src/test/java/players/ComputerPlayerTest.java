package players;

import exceptions.InvalidNumberException;
import java.util.ArrayList;
import java.util.Arrays;
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

    @Test
    void highRevolutionTest() {
        for (int i = 0; i < 100; i++) {
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

    @Test
    void 스트라이크_판정() {
        // given
        ComputerPlayer computer = new ComputerPlayer();
        String answer = arrayToString(computer.createNumber());
        // when
        List<String> userGuesses = new ArrayList<>(4);
        for (int i = 0; i < 4; i++) {
            userGuesses.add(changeNumber(i, answer));
        }
        // then
        for (int i = 0; i < 4; i++) {
            System.out.println(answer + " " + userGuesses.get(i));
            Assertions.assertEquals(3 - i, computer.countStrike(userGuesses.get(i)));
        }
    }

    String changeNumber(int changeCount, String original) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < original.length(); i++) {
            int n = original.charAt(i) - '0';
            if (i < changeCount) {
                n = nextNumberOf(n, 1, 9);
            }
            sb.append(n);
        }
        return sb.toString();
    }

    private int nextNumberOf(int n, int minInclude, int maxInclude) {
        int nextNumber = n + 1;
        if (nextNumber > maxInclude) {
            nextNumber = minInclude;
        }
        return nextNumber;
    }

    String arrayToString(int[] arr) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            str.append(arr[i]);
        }
        return str.toString();
    }

    void validateNumber(int[] number) throws InvalidNumberException {
        if (number.length != 3) {
            throw new InvalidNumberException();
        }
        int[] countOf = new int[10];
        for (int i = 0; i < 3; i++) {
            if (number[i] == 0) {
                throw new InvalidNumberException();
            }
            if (++countOf[number[i]] > 1) {
                throw new InvalidNumberException();
            }
        }
    }
}
