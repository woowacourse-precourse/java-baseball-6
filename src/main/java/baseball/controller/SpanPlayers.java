package baseball.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class SpanPlayers {
    public List<Integer> playerAttempt() {
        System.out.print("숫자를 입력해주세요 : ");

        String input = Console.readLine();

        List<Integer> digits = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            char digitChar = input.charAt(i);
            int digit = Character.getNumericValue(digitChar);
            digits.add(digit);
        }

        return digits;
    }


}

