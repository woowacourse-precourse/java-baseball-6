package baseball;

import java.util.List;

public class Validator {

    public static void validateProposal(String input) {
        validateLength(input);
        validateRange(input);
        validateDifferentNumber(input);
    }

    public static void validateNewOrQuit(String input) {
        validateOneOrTwo(input);
    }


    private static void validateLength(String input) {
        if (input.length() != 3) throw new IllegalArgumentException("입력값의 길이가 3이 아닙니다.");
    }

    private static void validateRange(String input) {
        for (char number : input.toCharArray()) {
            if (number < '1' || number > '9') throw new IllegalArgumentException("입력값의 범위가 맞지 않습니다.");
        }
    }

    private static void validateDifferentNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt((i + 1) % 3)) throw new IllegalArgumentException("서로 다른 3자리의 수가 아닙니다.");
        }
    }

    private static void validateOneOrTwo(String input) {
        List<String> possibleNumber = List.of("1", "2");
        if (!possibleNumber.contains(input)) throw new IllegalArgumentException("1(재시작) 또는 2(종료) 이외의 입력입니다.");
    }

}
