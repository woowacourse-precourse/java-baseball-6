package baseball.user;

import baseball.user.input.UserInput;
import java.util.ArrayList;
import java.util.List;

public class UserGenerate {
    /**
     * 사용자가 3개의 숫자 입력한 것 받기
     *
     * @return 3개의 숫자 리스트
     */
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
