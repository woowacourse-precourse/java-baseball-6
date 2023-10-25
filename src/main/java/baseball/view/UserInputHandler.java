package baseball.view;

import baseball.util.ErrorMessage;
import baseball.util.InvalidCustomException;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserInputHandler {
    public static int getIntInput() {
        int input = -1;
        boolean validInput = false;
        while (!validInput) {
            try {
                input = Integer.parseInt(Console.readLine());
                validInput = true;
            } catch (NumberFormatException e) {
                throw new InvalidCustomException(ErrorMessage.INVALID_INPUT);
            }
        }
        return input;
    }

    public static List<Integer> getIntArrayInput() {
        List<Integer> input = new ArrayList<>();
        boolean validInput = false;

        while (!validInput) {
            try {
                String inputStr = Console.readLine();
                String[] inputArr = inputStr.split("");

                if (inputArr.length != 3) {
                    throw new InvalidCustomException(ErrorMessage.INVALID_LENGTH);
                }

                for (int i = 0; i < 3; i++) {
                    input.add(Integer.parseInt(inputArr[i]));
                }

                validInput = true;
            } catch (NumberFormatException e) {
                throw new InvalidCustomException(ErrorMessage.INVALID_INPUT);
            }
        }

        return input;
    }
}
