package console;

import static baseball.GameNumber.EXIT;
import static baseball.GameNumber.NUMBER_LIMIT;
import static baseball.GameNumber.RESTART;

public class Validator {
    private static void validateType(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 타입입니다.");
        }
    }

    public static void validateInput(String input) {
        validateType(input);
        if (input.length() != NUMBER_LIMIT) throw new IllegalArgumentException("입력값은 세자리여야 합니다.");
        for(int i=0; i<input.length()-1; i++) {
            StringBuilder sb = new StringBuilder(input);
            sb.deleteCharAt(i);
            String target = sb.toString();
            if (target.contains(String.valueOf(input.charAt(i)))) throw new IllegalArgumentException("중복된 수를 입력할 수 없습니다.");
        }
    }

    public static void validateOption(String option) {
        validateType(option);
        int optionValue = Integer.parseInt(option);
        if (optionValue != RESTART && optionValue != EXIT) throw new IllegalArgumentException("잘못된 선택입니다.");
    }
}
