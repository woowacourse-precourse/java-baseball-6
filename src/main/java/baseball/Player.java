package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Player {

    public static final int NUMBER_SIZE = 3;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;

    private final List<Integer> numbers;

    private Player(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Player fromUserInput() {
        List<Integer> userInputNumbers = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");

        String[] userInput = Console.readLine().split("");
        for (String input : userInput) {
            int userInputNumber = Integer.parseInt(input);
            validateInput(userInputNumber, userInputNumbers);

            userInputNumbers.add(Integer.parseInt(input));
        }

        if (userInputNumbers.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }

        return new Player(userInputNumbers);
    }

    private static void validateInput(int userInputNumber, List<Integer> userInputNumbers) {

        if (userInputNumbers.contains(userInputNumber)) {
            throw new IllegalArgumentException();
        }

        if (userInputNumber < MIN_NUMBER || userInputNumber > MAX_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getPlayerNumbers() {
        return numbers;
    }
}
