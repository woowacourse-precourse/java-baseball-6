package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> computerNumber;
    private static final int numberSize = 3;
    private static final int startNumber = 1;
    private static final int endNumber = 9;

    public List<Integer> getComputerNumber() {
        return computerNumber;
    }

    public void drawComputerNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < numberSize) {
            int randomNumber = Randoms.pickNumberInRange(startNumber, endNumber);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        computerNumber = computer;
    }
}
