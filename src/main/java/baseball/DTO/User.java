package baseball.DTO;

import baseball.utils.ValidationUtils;

import java.util.List;

public class User {
    List<Integer> userNumbers;

     public User(String inputNumbers){
        ValidationUtils validationUtils = new ValidationUtils();
        userNumbers = validationUtils.validateNumbers(inputNumbers);
    }

    public List<Integer> getUserNumbers() {
        return userNumbers;
    }
}
