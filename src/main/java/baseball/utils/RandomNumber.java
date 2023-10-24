package baseball.utils;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    public static List<Integer> createComputerNumber() {
        List<Integer>computer = new ArrayList<>();
        while(computer.size() < 3) {
            createRandomNumber(computer);
        }
        return computer;
    }

    private static void createRandomNumber(List<Integer> computer) {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if(!computer.contains(randomNumber)) {
            computer.add(randomNumber);
        }
    }
}
