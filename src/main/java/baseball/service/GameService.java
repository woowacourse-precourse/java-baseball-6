package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class GameService {
    private List<Integer> computer;

    public void playGame() {

    }

    List<Integer> getComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }
}
