package baseball;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class UnitTest {

    private final Computer computer = new Computer(3);

    @Test
    void 임의의_수는_3자리이다() {
        int number = computer.generateRandomNumbers();

        assertTrue(number >= 100);
        assertTrue(number < 1000);
    }

    @Test
    void 임의의_수는_서로_다른_수이다() {
        int number = computer.generateRandomNumbers();
        int n1 = number / 100;
        int n2 = (number % 100) / 10;
        int n3 = number % 10;

        assertTrue(n1 != n2);
        assertTrue(n2 != n3);
        assertTrue(n3 != n1);
    }

    @Test
    void 임의의_수의_자리수는_10보다_작은_자연수이다() {
        int number = computer.generateRandomNumbers() % 10;

        assertTrue(number >= 1);
    }
}
