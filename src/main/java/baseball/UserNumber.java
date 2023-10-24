package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserNumber {
    public List<Integer> player() {
        List<Integer> userNumber = new ArrayList<>();

        try {
            System.out.print("숫자를 입력해주세요: ");
            String number = Console.readLine();

            if (number.length() != 3) {
                throw new IllegalArgumentException();
            }

            for (int i = 0; i<3; i++) {
                int digit = Character.getNumericValue(number.charAt(i));
                if (digit < 1 || digit > 9) {
                    throw new IllegalArgumentException();
                }
                userNumber.add(digit);
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
        return userNumber;
    }
}