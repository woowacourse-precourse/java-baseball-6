package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class ComputerNumber {
    private List<Integer> computer = new ArrayList<>();
    private final int listLength = 3;
    private final int startPoint = 1;
    private final int endPoint = 9;

    public ComputerNumber() {
        generateRandomNumber();
    }

    private void generateRandomNumber() {
        while (computer.size() < listLength) {
            int randomNumber = Randoms.pickNumberInRange(startPoint, endPoint);
            duplicateNumber(randomNumber);
        }
    }

    private void duplicateNumber(int randomNumber) {
        if(!computer.contains(randomNumber)){
            computer.add(randomNumber);
        }
    }

    public List<Integer> getComputerNumber() {
        return computer;
    }

}
