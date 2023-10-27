package baseball.service;

import baseball.model.Computer;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.message.Message.*;

public class ComputerService {

    public List<Integer> createComputerList() {
        Computer computer = new Computer(generateRandom());
        return computer.getComputer();
    }

    private List<Integer> generateRandom() {
        List<Integer> randomList = new ArrayList<>();
        while(randomList.size() < PLAYER_NUMBERS_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER , MAX_NUMBER);
            if (!randomList.contains(randomNumber)) {
                randomList.add(randomNumber);
            }
        }
        return new ArrayList<>(randomList);
    }
}
