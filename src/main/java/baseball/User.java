package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.LinkedList;

public class User {

    private final LinkedList<Integer> userNumbers = new LinkedList<>();

    public void askUserNumbers() {
        userNumbers.clear();

        String userInput = Console.readLine();
        for (char number : userInput.toCharArray()) {
            userNumbers.add(Character.getNumericValue(number));
        }
    }

    public LinkedList<Integer> getUserNumbers() {
        return userNumbers;
    }
}
