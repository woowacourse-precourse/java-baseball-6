package baseball.model.service;

import static baseball.model.constants.Rule.GAME_NUMBERS_MAX_VALUE;
import static baseball.model.constants.Rule.GAME_NUMBERS_MIN_VALUE;
import static baseball.model.constants.Rule.GAME_NUMBERS_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ComputerNumbersGeneratorImp implements ComputerNumbersGenerator {
    @Override
    public List<Integer> generateComputerNumbers() {
        return Stream.generate(() -> getRandomUniqueNumber(new ArrayList<>()))
                .limit(GAME_NUMBERS_SIZE.getValue())
                .collect(Collectors.toList());
    }

    private static int getRandomUniqueNumber(List<Integer> usedNumbers) {
        int randomNumber;
        do {
            randomNumber = getRandomNumber();
        } while (usedNumbers.contains(randomNumber));
        return randomNumber;
    }

    private static int getRandomNumber() {
        return Randoms.pickNumberInRange(GAME_NUMBERS_MIN_VALUE.getValue(), GAME_NUMBERS_MAX_VALUE.getValue());
    }
}