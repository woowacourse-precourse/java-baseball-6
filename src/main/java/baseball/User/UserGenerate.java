package baseball.User;

import baseball.User.Input.UserInput;

import java.util.ArrayList;
import java.util.List;

public class UserGenerate {
    public List<Integer> getAttempt() {
        UserInput userInputIsString = new UserInput();
        List<Integer> result = new ArrayList<>();
        String userInput;

        // 사용자 입력 받기
        userInput = userInputIsString.getGamingInput();

        // String -> List<Integer>
        for (char c : userInput.toCharArray()) {
            result.add(c - '0');
        }

        return result;
    }
}
