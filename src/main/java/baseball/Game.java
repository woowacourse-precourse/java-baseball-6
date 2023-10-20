package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    Player user;
    Player computer;

    public void initComputerNumbers() {
        List<Integer> computerNumbers = new ArrayList<Integer>(3);
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        this.computer.setPlayerNumbers(computerNumbers);
    }
}
