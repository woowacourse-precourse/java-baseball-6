package baseball.domain;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;


public class ComputerNumber {
    private final int LIST_LENGTH = 3;
    private final int START_POINT = 1;
    private final int END_POINT = 9;
    private List<Integer> computer = new ArrayList<>();
    public ComputerNumber() {
        generateRandomNumber();
    }

    private void generateRandomNumber() {
        while (computer.size() < LIST_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(START_POINT, END_POINT);
            addNumber(randomNumber);
        }
    }

    private void addNumber(int randomNumber) {
        if(!computer.contains(randomNumber)){
            computer.add(randomNumber);
        }
    }

    public List<Integer> getComputerNumber() {
        return computer;
    }
}
