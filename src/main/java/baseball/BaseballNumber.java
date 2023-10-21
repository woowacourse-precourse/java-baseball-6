package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BaseballNumber {

    private static final int NUMBER_LENGTH = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public static List<Integer> generateComputerNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < BaseballNumber.NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(BaseballNumber.MIN_NUMBER, BaseballNumber.MAX_NUMBER);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }

    public static List<Integer> generatePlayerNumber(String inputNumber) {
        validatePlayerNumber(inputNumber);
        return inputNumber.chars()
                .map(e -> e - '0')
                .boxed()
                .toList();
    }

    private static void validatePlayerNumber(String inputNumber) {
        if (inputNumber.length() != 3) {
            throw new IllegalArgumentException("INVALID NUMBER LENGTH");
        }
        Set<Integer> playerNumber = inputNumber.chars()
                .map(e -> e - '0')
                .boxed()
                .collect(Collectors.toSet());
        if (playerNumber.size() < NUMBER_LENGTH) {
            throw new IllegalArgumentException("DUPLICATE NUMBER");
        }
        if (playerNumber.stream().anyMatch(e -> e < 1 || e > 9)) {
            throw new IllegalArgumentException("INVALID NUMBER");
        }
    }
}
