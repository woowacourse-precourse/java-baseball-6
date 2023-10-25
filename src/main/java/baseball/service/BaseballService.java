package baseball.service;

import baseball.repository.BaseballRepository;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballService {
    public BaseballRepository baseballRepository = new BaseballRepository();

    public List<Integer> generateComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public void startNewGame() {
        List<Integer> newNumbers = generateComputerNumber();
        baseballRepository.saveComputer(newNumbers);
    }
}
