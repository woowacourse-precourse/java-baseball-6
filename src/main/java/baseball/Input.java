package baseball;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import camp.nextstep.edu.missionutils.Console;

public class Input {
    public String input() {
        return Console.readLine();
    }

    public List<Integer> toNumbers(String input) {
        List<Integer> numbers = Pattern.compile("")
                .splitAsStream(input)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        validateForNumberLength(numbers);
        validateForNumberRange(numbers);
        validateForDuplication(numbers);

        return numbers;
    }

    public void validateForNumberLength(List<Integer> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public void validateForNumberRange(List<Integer> numbers) {
        if(numbers.contains(0)) {
            throw new IllegalArgumentException();
        }
    }

    public void validateForDuplication(List<Integer> numbers) {
        int count = (int) numbers.stream().distinct().count();

        if (count < 3) {
            throw new IllegalArgumentException();
        }
    }
}