package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    //private List<Integer> computer = new ArrayList<>();
//    public List<Integer> getComputer() {
//        return computer;
//    }
    public List<Integer> generateRandomNumbers() {
        //computer.clear();
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.println(computer); // 추가
        return computer;
    }
}
