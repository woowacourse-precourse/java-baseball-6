package baseball.model.service;

import static baseball.model.constants.GameConstants.GAME_NUMBERS_MAX_VALUE;
import static baseball.model.constants.GameConstants.GAME_NUMBERS_MIN_VALUE;
import static baseball.model.constants.GameConstants.GAME_NUMBERS_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerNumbersGeneratorImp implements ComputerNumbersGenerator {
    @Override
    public List<Integer> generateComputerNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < GAME_NUMBERS_SIZE) {
            computerNumbers.add(getRandomUniqueNumber(computerNumbers));
        }
        return computerNumbers;
    }

    private int getRandomUniqueNumber(List<Integer> usedNumbers) {
        int randomNumber;
        do {
            randomNumber = getRandomNumber();
        } while (usedNumbers.contains(randomNumber));
        return randomNumber;
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(GAME_NUMBERS_MIN_VALUE, GAME_NUMBERS_MAX_VALUE);
    }
}