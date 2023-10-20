package baseball.presentation;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Set;

public class BaseballInputResolver {
    public String inputBaseballNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        validThreeDigitNumber(input);
        validDuplicateNumber(input);

        return input;
    }

    private void validThreeDigitNumber(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("숫자는 3자리만 입력 가능합니다.");
        }

        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    private void validDuplicateNumber(String input) {
        Set<Character> number = new HashSet<>();
        for (char c : input.toCharArray()) {
            if (number.contains(c)) {
                throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.");
            }

            number.add(c);
        }
    }


}
