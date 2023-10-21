package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UserInput {
    public static List<Integer> inputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputString = Console.readLine();
        List<Integer> inputNumbers;
        try {
            inputNumbers = new ArrayList<>(List.of(Integer.parseInt(inputString)));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        validateInputNumbers(inputNumbers);
        return inputNumbers;
    }

    private static void validateInputNumbers(List<Integer> numbers) {
        validateSize(numbers);
        validateNonzero(numbers);
        validateDuplicate(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNonzero(List<Integer> numbers) {
        if (numbers.contains(0)) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> set = Set.copyOf(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }
}
