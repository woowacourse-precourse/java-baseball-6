package baseball.service;

import baseball.view.ErrorMessage;
import baseball.vo.User;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputNumbers {
    public static User setInputNumber() {
        List<Integer> inputNumber = new ArrayList<>();
        String input = Console.readLine();
        checkDigit(input.length());
        for (char inputChar : input.toCharArray()) {
            checkNumber(inputChar);
            int number = charToInt(inputChar);
            checkDuplicate(inputNumber, number);
            inputNumber.add(number);
        }
        User user = new User();
        user.setUserNumbers(inputNumber);
        return user;
    }

    public static void checkDigit(int size) {
        if (size != 3) {
            throw new IllegalArgumentException(ErrorMessage.SIZE_ERROR);
        }
    }

    public static void checkNumber(char number) {
        if (number < 49 || number > 57) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUM_ERROR);
        }
    }

    public static int charToInt(char inputNumber) {
        return inputNumber - '0';
    }

    public static void checkDuplicate(List<Integer> inputNumber, int checkNumber) {
        if (inputNumber.indexOf(checkNumber) != -1) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUM_ERROR);
        }
    }

}
