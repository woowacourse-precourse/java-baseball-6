package baseball.domain;

import baseball.validation.Validation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class User {
    private static final String NUMBER_REGEXP = "^[1-9]{3}$";
    private static final String STRING_REGEXP = "^[a-zA-Z]$";
    private static final String RETRY_REGEXP = "[1|2]";
    private static final String RETRY = "1";
    private final List<Integer> userNumbers;
    private final List<Integer> numberList = new ArrayList<>();

    public User(String userInput){
        this.userNumbers = createUserNumbers(userInput);
    }

    private List<Integer> createUserNumbers(String userInput) {
        if(validation(userInput,STRING_REGEXP)) throw new IllegalArgumentException(Validation.INVALID_NOT_NUMBER);
        if(!validation(userInput,NUMBER_REGEXP)) throw new IllegalArgumentException(Validation.INVALID_NUMBER_RANGE);

        for (char digit : userInput.toCharArray()) {
            int typeConvert = Integer.parseInt(String.valueOf(digit));
            if(isDuplicateNumber(typeConvert)) throw new IllegalArgumentException(Validation.INVALID_DUPLICATE_NUMBER);
            numberList.add(typeConvert);
        }
        return numberList;
    }

    public List<Integer> getUserNumbers() {
        return this.userNumbers;
    }


}
