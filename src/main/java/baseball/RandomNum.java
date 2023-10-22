package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.List;

public class RandomNum {
    RandomNum(List<Integer> computer) {
        while (computer.size() < 3) {
            int randomNumber = pickNumberInRange(1, 9); // 1~9 랜덤 수 출력
            if (!computer.contains(randomNumber)) { // 서로 다른 수
                computer.add(randomNumber);
            }
        }
        System.out.println(computer);
    }
}
