package input;

import static error.ErrorMessage.DUPLICATE_NUMBER;
import static error.ErrorMessage.INVALID_NUMBER;
import static error.ErrorMessage.INVALID_NUMBER_RANGE;
import static error.ErrorMessage.INVALID_SIZE;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BaseBallGameUserInput implements UserInput<List<Integer>> {
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final int INPUT_MAX = 9;
    private static final int INPUT_MIN = 1;

    @Override
    public List<Integer> input(Integer inputSize) {
        System.out.print(INPUT_MESSAGE);

        final String inputString = Console.readLine();

        final List<Character> inputList = inputString.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> !Objects.equals(c, ' '))
                .collect(Collectors.toList());

        validateInput(inputList, inputSize);

        return inputList.stream()
                .map(Character::getNumericValue)
                .collect(Collectors.toList());
    }

    @Override
    public void close() {
        Console.close();
    }

    private void validateInput(List<Character> inputList, Integer inputSize) {
        validateInputSize(inputList, inputSize);
        validateInputRange(inputList);
        validateInputNumber(inputList);
        validateInputDuplicate(inputList);
    }

    private void validateInputSize(List<Character> inputList, Integer inputSize) {
        if (inputList.size() != inputSize) {
            throw new IllegalArgumentException(INVALID_SIZE.getMessage());
        }
    }

    private void validateInputRange(List<Character> inputList) {
        if (inputList.stream().anyMatch(c -> c - '0' < INPUT_MIN || c - '0' > INPUT_MAX)) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE.getMessage());
        }
    }


    private void validateInputNumber(List<Character> inputList) {
        if (inputList.stream().anyMatch(c -> !Character.isDigit(c))) {
            throw new IllegalArgumentException(INVALID_NUMBER.getMessage());
        }
    }

    private void validateInputDuplicate(List<Character> inputList) {
        if (inputList.stream().distinct().count() != inputList.size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER.getMessage());
        }
    }
}
