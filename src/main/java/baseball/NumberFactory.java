package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.Constant.*;

public class NumberFactory {

    public static List<Integer> createByComputer(NumberGameConfiguration numberGameConfiguration) {
        int minimumNumberOfRange = numberGameConfiguration.getMinimumNumberOfRange();
        int maximumNumberOfRange = numberGameConfiguration.getMaximumNumberOfRange();
        int numberOfDigits = numberGameConfiguration.getNumberOfDigits();

        List<Integer> computerNumbers = new ArrayList<>();

        while (computerNumbers.size() < numberOfDigits) {
            int randomNumber = Randoms.pickNumberInRange(minimumNumberOfRange,
                maximumNumberOfRange);

            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }

        return computerNumbers;
    }

    public static List<Integer> createByUser() {
        System.out.print(UserRequestMessage.GUESS_NUMBER_REQUEST_MESSAGE);
        String userInput = Console.readLine();
        List<Integer> userNumbers = parseUserInput(userInput);

        return userNumbers;
    }

    private static List<Integer> parseUserInput(String userInput) {
        List<Integer> userNumbers = new ArrayList<>();

        for (char digit : userInput.toCharArray()) {
            if (!Character.isDigit(digit)) {
                throw new IllegalArgumentException();
            }

            int number = Integer.parseInt(String.valueOf(digit));

            if (userNumbers.contains(number)) {
                throw new IllegalArgumentException();
            }

            userNumbers.add(number);
        }

        return userNumbers;
    }
}
