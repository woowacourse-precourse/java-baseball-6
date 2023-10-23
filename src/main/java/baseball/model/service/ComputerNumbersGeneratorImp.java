package baseball.model.service;

import static baseball.model.constants.GameConstants.PLAYER_NUMBERS_MAX_VALUE;
import static baseball.model.constants.GameConstants.PLAYER_NUMBERS_MIN_VALUE;
import static baseball.model.constants.GameConstants.PLAYER_NUMBERS_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerNumbersGeneratorImp implements ComputerNumbersGenerator {
    @Override
    public List<Integer> generate() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < PLAYER_NUMBERS_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(PLAYER_NUMBERS_MIN_VALUE, PLAYER_NUMBERS_MAX_VALUE);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
