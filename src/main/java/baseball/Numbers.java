package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

/**
 * The 'Numbers' class handles the generation and validation of numbers sequences for the baseball game.
 * */
public class Numbers {
    private static final int NUMBERS_SIZE = 3;
    List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        validateSize(numbers);
        validateScope(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException("숫자는 3개 입력해야한다.");
        }
    }

    private void validateScope(List<Integer> numbers) {
        for (int n : numbers) {
            if (n < 1 || n > 9) {
                throw new IllegalArgumentException("숫자는 1에서 9까지 입력가능하다.");
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        int[] digits = new int[10];
        for (int n : numbers) {
            digits[n]++;
            if (digits[n] > 1) {
                throw new IllegalArgumentException("숫자는 중복될 수 없습니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public static int getMaxLength() {
        return NUMBERS_SIZE;
    }

    /**
     * Generate and return a random numbers (computer-generated numbers) for the game.
     * @return A 'Numbers' object representing the computer's numbers.
     * */
    public static Numbers getComputerNumbers() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < NUMBERS_SIZE) {

            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }

        }
        return new Numbers(computer);
    }

    /**
     * Get the player's number sequence input from the console.
     * @return A 'Numbers' object representing the player's numbers.
     * @throws IllegalArgumentException if the plyear's input is invalid.
     * */
    public static Numbers getPlayerNumbers() {
        List<Integer> player = new ArrayList<>();

        Printer.askNumbers();
        String inputStr = Console.readLine();

        for (int i = 0; i < inputStr.length(); i++) {
            int inputNumber = inputStr.charAt(i) - '0';
            player.add(inputNumber);
        }
        return new Numbers(player);
    }
}
