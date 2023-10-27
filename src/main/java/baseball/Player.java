package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {

    public static List<Integer> getPlayerInputNumbers() {
        System.out.println("숫자를 입력해주세요 : ");
        String inputNumbers = Console.readLine();
        return validatePlayerInputNumbers(inputNumbers);
    }

    private static List<Integer> validatePlayerInputNumbers(String inputNumbers) {
        validateNoBlankInput(inputNumbers);
        validateThreeDigitInput(inputNumbers);

        List<Integer> playerNumbers = new ArrayList<>();

        inputNumbers.chars().forEach(c -> {
            int number = Character.getNumericValue(c);
            validateNumberInRange(c);
            checkDuplicate(number, playerNumbers);
            playerNumbers.add(number);
        });
        return playerNumbers;
    }

    private static void validateNoBlankInput(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("공백은 입력할 수 없습니다. 3자리의 숫자를 입력해주세요.");
        }
    }

    private static void validateThreeDigitInput(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리의 숫자만 입력 가능합니다.");
        }
    }

    private static void validateNumberInRange(int c) {
        if (!(c >= '1' && c <= '9')) {
            throw new IllegalArgumentException("1부터 9까지의 3자리 숫자만 입력 가능합니다.");
        }
    }

    private static void checkDuplicate(int num, List<Integer> numbers) {
        if (numbers.contains(num)) {
            throw new IllegalArgumentException("중복된 숫자는 허용되지 않습니다.");
        }
    }
}