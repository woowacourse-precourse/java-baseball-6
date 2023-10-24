package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class User {
    private List<Integer> numbers;

    public User() {
        this.numbers = new ArrayList<>();
    }

    public void input() {
        String[] userInput = Console.readLine().split("");
        validateUserInput(userInput);
        Arrays.stream(userInput).forEach(s -> numbers.add(Integer.parseInt(s)));
    }

    private void validateUserInput(String[] userInput) {
        if (userInput.length != 3) {
            throw new IllegalArgumentException();
        }
        if (Objects.equals(userInput[0], userInput[1]) || Objects.equals(userInput[0], userInput[2]) || Objects.equals(userInput[1], userInput[2])) {
            throw new IllegalArgumentException();
        }
        for (String s : userInput) {
            if (Integer.parseInt(s) < 1 || Integer.parseInt(s) > 9) {
                throw new IllegalArgumentException();
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
