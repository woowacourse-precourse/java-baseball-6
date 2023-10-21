package baseball.Model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    /**
     * Model은 Controller와 View에 관련된 코드가 있으면 안된다!!!!!!
     */
    public List<Integer> generatorComputerNumber(int baseballNumSize){
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < baseballNumSize) {
            int num = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(num)) {
                computerNumber.add(num);
            }
        }
        return computerNumber;
    }
}
