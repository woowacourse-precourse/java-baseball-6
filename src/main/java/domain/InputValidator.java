package domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {

    private static final int INPUT_NUMBER_COUNT = 3;


    public String validateAndReturnInput() {

        String input = Console.readLine();

        if (input.length() != INPUT_NUMBER_COUNT) {
            throw new IllegalArgumentException("3자리의 숫자를 입력해야 합니다.");
        }

        Set<Character> uniqueNumbers = new HashSet<>();

        for (char ch : input.toCharArray()) {
            if (ch < '1' || ch > '9') {
                throw new IllegalArgumentException("1부터 9 사이의 숫자만 입력해야 합니다.");
            }

            uniqueNumbers.add(ch);
        }

        if (uniqueNumbers.size() != INPUT_NUMBER_COUNT) {
            throw new IllegalArgumentException("중복되는 숫자를 입력하였습니다.");
        }

        return input;
    }
    public String validateAndReturnGameContinuationChoice() {
        String input = Console.readLine();

        if (!"1".equals(input) && !"2".equals(input)) {
            throw new IllegalArgumentException("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }

        return input;
    }

}
