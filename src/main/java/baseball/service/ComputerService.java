package baseball.service;

import baseball.model.Computer;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerService {

    public List<Integer> createComputerList() {
        Computer computer = new Computer(generateRandom());
        return computer.getComputer();
    }

    private List<Integer> generateRandom() {
        List<Integer> randomList = new ArrayList<>();
        while(randomList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomList.contains(randomNumber)) {
                randomList.add(randomNumber);
            }
        }
        return new ArrayList<>(randomList);
    }
}
