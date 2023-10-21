package baseball.service;

import baseball.domain.User;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

/**
 * 2. input() : 사용자의 입력 받기
 */
public class MakeUserAnswer {
    private final UserValidation userValidation;

    public MakeUserAnswer(UserValidation userValidation) {
        this.userValidation = userValidation;
    }

    public User input() {
        String userInputString = readInput();
        int validatedInput = validateInput(userInputString);
        List<Integer> userValue = createUserValue(validatedInput);

        return User.createUser(userValue);
    }

    private String readInput() {
        return Console.readLine();
    }

    private int validateInput(String userInput) {
        return userValidation.validation(userInput);
    }

    private List<Integer> createUserValue(int number) {
        List<Integer> digits = new ArrayList<>();

        digits.add(number / 100);
        number %= 100;

        digits.add(number / 10);
        number %= 10;

        digits.add(number);

        return digits;
    }

}