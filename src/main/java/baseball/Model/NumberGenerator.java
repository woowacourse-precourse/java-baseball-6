package baseball.Model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    private static final int BASEBALL_NUM_SIZE = 3;
    public List<Integer> generatorComputerNumber(){
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < BASEBALL_NUM_SIZE) {
            int num = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(num)) {
                computerNumber.add(num);
            }
        }
        return computerNumber;
    }
}
