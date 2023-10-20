package baseball.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class GenerateUserNum {

    public List<Integer> userInputNumbers() {

        System.out.print("숫자를 입력해주세요 : ");

        List<Integer> userInputNumbers = new ArrayList<>();
        String number = Console.readLine();

        if (number.length() != 3) {
            throw new IllegalArgumentException();
        }

        for (char c : number.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException();
            }
            userInputNumbers.add(Character.getNumericValue(c));
        }
        return userInputNumbers;
    }
}

