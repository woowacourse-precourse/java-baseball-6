package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    List<Integer> answer = new ArrayList<>();

    public void initGame() {
        int randomNumber;
        int length = 0;

        // 3개의 숫자를 만들어 list에 추가. 서로 다른 숫자여야함.
        while (length < 3) {
            randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
                length++;
            }
        }
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
}
