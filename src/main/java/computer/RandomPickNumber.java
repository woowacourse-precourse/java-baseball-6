package computer;

import camp.nextstep.edu.missionutils.Randoms;
import constant.StringConstant;

import java.util.ArrayList;
import java.util.List;

public class RandomPickNumber {
    public static List<Integer> computer = new ArrayList<>();

    public static List<Integer> randomPickNumber() {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(StringConstant.MIN_NUMBER, StringConstant.MAX_NUMBER);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static void RandomPickClean(){
        computer = new ArrayList<>();
    }

}
