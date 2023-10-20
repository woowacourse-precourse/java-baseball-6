package baseball.infra;

import baseball.domain.BaseballNumberGenerator;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserBaseballNumberGenerator implements BaseballNumberGenerator {
    @Override
    public List<Integer> generateBaseballNumber(int length) throws IllegalArgumentException{
        String inputNumbers = Console.readLine();
        assertValidLength(inputNumbers, length);

        List<Integer> baseballNumber = convertFromUserInputToList(inputNumbers);

        assertNotDuplicateNumbers(baseballNumber);

        return baseballNumber;
    }

    private void assertValidLength(String inputNumbers, int length) {
        if (inputNumbers.length() != length) {
            throw new IllegalArgumentException(String.format("숫자의 길이는 %d 여야 합니다.", length));
        }
    }

    private List<Integer> convertFromUserInputToList(String inputNumbers) {
        List<Integer> baseballNumber = new ArrayList<>();

        for (int i = 0; i < inputNumbers.length(); i++) {
            baseballNumber.add((int) inputNumbers.charAt(i));
        }

        return baseballNumber;
    }

    private void assertNotDuplicateNumbers(List<Integer> inputNumbers) {
        Set<Integer> tmpNumbers = new HashSet<>(inputNumbers);

        if (tmpNumbers.size() != inputNumbers.size()) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다!");
        }
    }
}
