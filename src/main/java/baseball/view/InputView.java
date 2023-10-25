package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public static List<Integer> inputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        return convertInputToNumberList(input);
    }

    private static List<Integer> convertInputToNumberList(String input) {
        validationInputFormat(input);

        return input.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }

    private static void validationInputFormat(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }
    }
}
