package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseBall {
    public static String creatNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < Application.validLength) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer num : computer) {
            stringBuilder.append(num);
        }
        return stringBuilder.toString();
    }
}
