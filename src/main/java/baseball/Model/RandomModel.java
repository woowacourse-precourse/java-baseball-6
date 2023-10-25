package baseball.Model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomModel {
    public static NumberModel getRandom3Number(){
        // 랜덤 1~9 서로 다른 수로 이루어진 3자리 수 생성
        List<Integer> computer = new ArrayList<>();
        while(computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return new NumberModel(computer.get(0),computer.get(1),computer.get(2));
    }
}
