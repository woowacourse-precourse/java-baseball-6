package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private final List<Integer> computerNumber = new ArrayList<>();

    public Computer() {
        generateRandomNumbers();
    }
    public void generateRandomNumbers() {
        while (computerNumber.size() < 3) {
            addComputerNumber();
//            addTestComputerNumber();
        }
    }

    private void addTestComputerNumber() {
        //테스트 용
        for (int i = 1; i <= 3; i ++) {
            computerNumber.add(i);
        }
    }

    private void addComputerNumber() {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (!computerNumber.contains(randomNumber)) {
            computerNumber.add(randomNumber);
        }
    }

    public List<Integer> getComputerNumber() {
        return computerNumber;
    }
}