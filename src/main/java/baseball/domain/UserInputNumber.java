package baseball.domain;


import baseball.exception.UserInputException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserInputNumber {
    private List<Integer> userNumber = new ArrayList<>();
    private UserInputException userInputException;

    public UserInputNumber(String userInput) {
        this.userInputException = new UserInputException();
        this.userNumber = createUserNumber(userInput);
    }

    private List<Integer> createUserNumber(String userInput) throws IllegalArgumentException {
        List<Integer> userNumber = StringToInt(userInput);
        if(userInputException.Validation(userNumber)) {
            return userNumber;
        }
        throw new IllegalArgumentException();
    }

    private List<Integer> StringToInt(String userInput) {
        for(String number : userInput.split("")){
            this.userNumber.add(Integer.parseInt(number));
        }
        return userNumber;
   }

    public List<Integer> getUserNumber() {
        return userNumber;
    }
}
