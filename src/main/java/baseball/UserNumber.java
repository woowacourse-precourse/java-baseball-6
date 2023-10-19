package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserNumber {
    private List<Integer> userNumber;

    public UserNumber() {
        userNumber = new ArrayList<>();
        while (userNumber.size() < 3) {
            String userNumber = Console.readLine();
        }
    }
}
