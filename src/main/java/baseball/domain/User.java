package baseball.domain;

import static baseball.constants.ErrorMessage.USER_INPUT_MESSAGE;
import static baseball.validation.ValidateUserNumber.validateUserNumber;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class User {

    public List<Integer> createUserNumber() {
        System.out.print(USER_INPUT_MESSAGE);
        String userInput = Console.readLine();

        ArrayList<Integer> userNumber = new ArrayList<>();

        validateUserNumber(userInput, userNumber);

        return userNumber;
    }
}
