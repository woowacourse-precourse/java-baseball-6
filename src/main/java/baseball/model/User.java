package baseball.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class User {

    private String userNumber;

    public String getUserNumber(){
        return userNumber;
    }
    public void setUserNumber(String userInput) {
        this.userNumber = userInput;
    }

    // 1. 메인에 예외 처리를 전가 하기 위해 throws IllegalArgumentException 맞는지 ? 아래에 조건에서만 예외 발생시키면 되는거 아닌가?
    public void validateUserInput(String userInput) throws IllegalArgumentException {
        String regex = "[0-9]+";
        boolean isInvalidDigit = !userInput.matches(regex);

        if (isInvalidDigit || userInput.length() > 3) {
            throw new IllegalArgumentException();
        }
    }

}
