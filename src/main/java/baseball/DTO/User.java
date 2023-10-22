package baseball.DTO;

import baseball.utils.ValidationUtils;

import java.util.List;

public class User {
    List<Integer> userNumbers;

    public User(String inputNumbers){
        new ValidationUtils(inputNumbers);
    }

    public List<Integer> getUserNumbers() {
        return userNumbers;
    }
}
