package baseball.domain;

import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private List<Integer> numbers;

    public void inputNumbers() {
        InputView.printInputPlayerNumbers();
        String inputNumbers = Console.readLine();
        validateInputNumbers(inputNumbers);
        this.numbers = convertStringToList(inputNumbers);
    }

    private void validateInputNumbers(String inputNumbers) {
        if (inputNumbers.length() != 3) {
            throw new IllegalArgumentException("입력 값은 반드시 3자리여야 합니다.");
        }

        if (!inputNumbers.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("입력 값은 반드시 숫자여야 합니다.");
        }

        char[] digits = inputNumbers.toCharArray();
        if (digits[0] == digits[1] || digits[0] == digits[2] || digits[1] == digits[2]) {
            throw new IllegalArgumentException("입력 값은 중복되지 않은 숫자여야 합니다.");
        }
    }

    private List<Integer> convertStringToList(String inputNumber) {
        return Arrays.stream(inputNumber.split(""))
                .mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
