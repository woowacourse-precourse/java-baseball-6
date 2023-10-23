package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserInput {
    public static List<Integer> validatedUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        List<Integer> userNumber = new ArrayList<>();

        if (input.length() != 3) {
            throw new IllegalArgumentException("옳지 않은 입력입니다. 3자리 수를 입력해주세요.");
        }

        for (int i = 0; i < input.length(); i++) {
            char digitChar = input.charAt(i);
            if (!Character.isDigit(digitChar)) {
                throw new IllegalArgumentException("옳지 않은 입력입니다. 숫자를 입력해주세요.");
            }
            int digit = Character.getNumericValue(digitChar);
            userNumber.add(digit);
        }
        if (userNumber.get(0) == userNumber.get(1) || userNumber.get(0) == userNumber.get(2) || userNumber.get(1) == userNumber.get(2)) {
            throw new IllegalArgumentException("옳지 않은 입력입니다. 각기 다른 3자리 수를 입력해주세요.");
        }

        return userNumber;
    }
}