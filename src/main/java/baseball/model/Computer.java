package baseball.model;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    private static final int COMPUTER_NUMBERS_SIZE = 3;
    private final List<Integer> computer;

    public Computer(List<Integer> computer) {
        this.computer = computer;
    }

    public void generateRandom() {
        while(computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    private void validateSize(List<Integer> computer){
        if (computer.size() != COMPUTER_NUMBERS_SIZE) {
            throw new IllegalArgumentException("컴퓨터는 3가지 숫자만 받아야 합니다.");
        }
    }
}
