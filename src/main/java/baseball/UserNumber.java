package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserNumber {
    private final List<Integer> userNumber;

    public UserNumber() {
        userNumber = new ArrayList<>();
        try {
            String userNum = Console.readLine();
            String[] numbers = userNum.split("");
            
            if (numbers.length == 3) {
                for (String numStr : numbers) {
                    int number = Integer.parseInt(numStr);
                    userNumber.add(number);
                }
            } else {
                System.exit(1); // 입력된 숫자 3자리가 아닌 경우 종료
            }
        } catch (IllegalArgumentException e) {
            System.exit(1); // 입력된 숫자가 잘못된 경우 종료
        }
    }

    public List<Integer> getUserNumbers() {
        return userNumber;
    }
}
