package baseball.component;

import java.util.*;
import java.util.stream.Collectors;
import camp.nextstep.edu.missionutils.Console;

public class Inputer {

    public List<Integer> input() {
        String input;

        System.out.print("숫자를 입력해주세요 : ");
        input = Console.readLine();
        return convertToDigit(input);
    }

    private List<Integer> convertToDigit(String s) {
        List<Integer> input;
        try {
            input = Arrays.stream(s.split("")).mapToInt(Integer::parseInt).boxed()
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        validate(input);
        return input;
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> validateSet = new HashSet<>(numbers);
        if (validateSet.size() != 3 || numbers.size() != 3) {
            throw new IllegalArgumentException();
        }
    }
}
