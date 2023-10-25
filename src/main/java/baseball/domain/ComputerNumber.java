package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class ComputerNumber {
    private final int listLength = 3;
    private final int startPoint = 1;
    private final int endPoint = 9;
    private List<Integer> computer = new ArrayList<>();
    public ComputerNumber() {
        generateRandomNumber();
    }
    private void generateRandomNumber() {
        while (computer.size() < listLength) {
            int randomNumber = Randoms.pickNumberInRange(startPoint, endPoint);
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
