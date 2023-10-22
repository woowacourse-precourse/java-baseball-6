package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        // 랜덤으로 서로 다른 수 3개 생성
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }
}
