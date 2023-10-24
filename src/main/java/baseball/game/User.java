package baseball.game;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {

    public User() {
    }

    public List<Integer> createUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();

        List<Integer> userNumber = validateUserNumber(userInput);

        return userNumber;
    }

    public List<Integer> validateUserNumber(String userInput) {
        ArrayList<Integer> userNumber = new ArrayList<>();
        for (int i = 0; i < userInput.length(); i++) {
            char numberChar = userInput.charAt(i);
            if (!Character.isDigit(numberChar)) {
                throw new IllegalArgumentException("숫자가 아닌 입력이 포함되어 있습니다.");
            }
            userNumber.add((int) numberChar - '0');
        }

        if (userNumber.size() != 3) {
            throw new IllegalArgumentException("입력숫자가 3자리가 아닙니다.");
        }

        Set<Integer> set = new HashSet<>(userNumber);
        if (set.size() != userNumber.size()) {
            throw new IllegalArgumentException("중복되는 숫자가 포함되어 있습니다.");
        }

        for (int number : userNumber) {
            if (number == 0) {
                throw new IllegalArgumentException("입력숫자에 0이 포함되어 있습니다.");
            }
        }
        return userNumber;
    }
}
