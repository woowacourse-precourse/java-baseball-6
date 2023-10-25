package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Computer {
    public static List<Integer> generateComputerNum(List<Integer> computerNum, int NUMBER_LENGTH) {
        while (computerNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber);
            }
        }
        return computerNum;
    }
}
