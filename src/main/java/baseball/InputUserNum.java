package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class InputUserNum {
    public List<Integer> userNum() {
        System.out.println("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();

        List<Integer> userNumber = new ArrayList<>();
        Set<Integer> uniqueDigits = new HashSet<>();

        for (String num : userInput.split("")) {
            int digit = Integer.parseInt(num);

            // 중복된 숫자 있는지 검사
            if (digit < 1 || digit > 9 || uniqueDigits.contains(digit)) {
                throw new IllegalArgumentException();
            }

            userNumber.add(digit);
            uniqueDigits.add(digit);
        }

        // 입력된 숫자 자리수 검사
        if (userNumber.size() != 3) {
            throw new IllegalArgumentException();
        }

        return userNumber;
    }
}
