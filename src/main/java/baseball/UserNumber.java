package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserNumber {
    public List<Integer> UserNumber() {
        List<Integer> userNumber = new ArrayList<>();
        try {
            System.out.print("숫자를 입력해주세요: ");
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
        return userNumber;
    }

}