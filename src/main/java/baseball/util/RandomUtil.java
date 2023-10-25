package baseball.util;

import static baseball.model.Rule.END_NUM;
import static baseball.model.Rule.LENGTH;
import static baseball.model.Rule.START_NUM;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomUtil {

    public static List<Integer> generateComputer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(START_NUM, END_NUM);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
