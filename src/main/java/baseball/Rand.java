package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Rand {
    Rand() {

    }

    List<Integer> makeRandomNumber() { // 중복되지 않는 세자리수 난수를 생성하는 함수
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9); // 1~9까지 랜덤한 정수 생성
            if (!computer.contains(randomNumber)) { // 중복되지 않는 값으로 선별
                System.out.println(randomNumber);
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
