package baseball.input;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class BaseBallGameUserInput implements UserInput<List<Integer>> {
    private static final String INPUT_FORMAT = "숫자를 입력해주세요 :";
    @Override
    public List<Integer> input(Integer inputSize) {
        System.out.print(INPUT_FORMAT);
        final String inputString = Console.readLine();
        final List<Character> inputCharacterList = inputString.chars()
            .mapToObj(c -> (char) c)
            .filter(c -> !Objects.equals(c, ' '))
            .toList();
        validateInput(inputCharacterList, inputSize);
        return inputCharacterList.stream()
            .map(c -> c-'0')
            .collect(Collectors.toList());
    }

    @Override
    public void close() {
        Console.close();
    }

    private void validateInput(List<Character> validateTarget, Integer inputSize) {
        validateInputCharacterLength(validateTarget, inputSize);
        validateInputCharacterComposedWithNumber(validateTarget);
        validateInputCharacterComposeWithUniqueValue(validateTarget);
    }

    private void validateInputCharacterLength(List<Character> validateTarget, Integer inputSize) {
        if (validateTarget.size() != inputSize) {
            throw new IllegalArgumentException();
        }
    }

    private void validateInputCharacterComposedWithNumber(List<Character> validateTarget) {
        for (char c : validateTarget) {
            final int validateCharValue = c - '0';
            if (validateCharValue < 1 || validateCharValue > 9) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateInputCharacterComposeWithUniqueValue(List<Character> validateTarget) {
        Set<Character> uniqueCharacterSet = new HashSet<>(validateTarget);
        if(uniqueCharacterSet.size()!=validateTarget.size()){
            throw new IllegalArgumentException();
        }
    }
}
