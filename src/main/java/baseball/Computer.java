package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private final List<Integer> computer = new ArrayList<>();

    public Computer() {
        generateRandomNumbers();
    }
    public void generateRandomNumbers() {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        //테스트 용
//        for (int i = 1; i <= 3; i ++) {
//            computer.add(i);
//        }
    }

    public List<Integer> getComputer() {
        return computer;
    }
}