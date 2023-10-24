package baseball.feature;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberMaker {
    public List<Integer> maker() {
        List<Integer> computerNumbers = new ArrayList<>();
        //1~9 숫자 생성
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            // 서로 다른 임의의 수인지 확인
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return computerNumbers;
    }
}