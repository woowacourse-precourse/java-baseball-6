package baseball.DTO;

import baseball.utils.ValidationUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    private final List<Integer> userNumbers;

    public User(String inputNumbers){
        ValidationUtils validationUtils = new ValidationUtils();
        userNumbers = parseStringToInteger(validationUtils.validateNumbers(inputNumbers));
    }

    public List<Integer> parseStringToInteger(String userInputNumber) {
        return Arrays.stream(userInputNumber.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
    public List<Integer> getUserNumbers(){
        return userNumbers;
    }
}
