package baseball.controller;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class PlayerAttempt {
    public List<Integer> attempt() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        List<Integer> digits = new ArrayList<>();

        if (input.length() == 3) {

            for (int i = 0; i < 3; i++) {
                char digitChar = input.charAt(i);
                int digit = Character.getNumericValue(digitChar);
                digits.add(digit);
            }
        } else {
            throw new IllegalArgumentException("입력은 세자리여야합니다.");
        }
        return digits;
    }
}

