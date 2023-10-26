package baseball.domain;

import baseball.common.GameValue;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NumberGenerator {
    private NumberGenerator() {
    }

    public static Number createComputerNumber() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < GameValue.NUMBER_SIZE.getValue()) {
            addUniqueRandomNumber(computerNumbers);
        }
        return new Number(computerNumbers);
    }

    public static Number createPlayerNumber(String input) {
        List<Integer> playerNumbers = input.chars()
                .map(c -> c - '0')
                .boxed()
                .collect(Collectors.toList());
        return new Number(playerNumbers);
    }

    private static void addUniqueRandomNumber(List<Integer> numbers) {
        int number = Randoms.pickNumberInRange(GameValue.MIN_RANGE.getValue(), GameValue.MAX_RANGE.getValue());
        if (!numbers.contains(number)) {
            numbers.add(number);
        }
    }
}
