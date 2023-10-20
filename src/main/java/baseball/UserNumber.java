package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserNumber {
    private final List<Integer> userNumber;

    public UserNumber() {
        userNumber = new ArrayList<>();
        while (userNumber.size() < 3) {
            String userNum = Console.readLine();
            int number = Integer.parseInt(userNum);
            userNumber.add(number);
        }
    }

    public List<Integer> getUserNumbers() {
        return userNumber;
    }
}
