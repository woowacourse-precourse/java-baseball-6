package baseball;

import baseball.validators.LengthValidator;
import baseball.validators.NoDuplicateValidator;
import baseball.validators.RangeValidator;
import baseball.validators.Validator;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Arrays;

public class User {
    private String userNumber;
    private List<Validator> validators;

    public User() {
        this.validators = Arrays.asList(new LengthValidator(), new NoDuplicateValidator(), new RangeValidator());
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void inputUserNumber() {
        // 사용자에게 3자리 숫자 입력받기
        String userNumber = Console.readLine();

        validateUserInput(userNumber);

        this.userNumber = userNumber;
    }

    private void validateUserInput(String userInput) {
        for (Validator validator : validators) {
            validator.validate(userInput);
        }
    }
}