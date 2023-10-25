package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static baseball.exception.NumberException.*;
import static java.lang.Character.getNumericValue;

public class Player {
    private final static String INPUT_MSG = "숫자를 입력해주세요 : ";

    public static List<Integer> getUserInput() {
        System.out.print(INPUT_MSG);
        String input = Console.readLine();

        validateNumericInput(input);
        validateDigit(input);
        validateRange(input);
        validateDuplicate(input);

        List<Integer> numbers = new ArrayList<>();
        for (char number : input.toCharArray()) {
            numbers.add(getNumericValue(number));
        }

        return numbers;
    }
}
