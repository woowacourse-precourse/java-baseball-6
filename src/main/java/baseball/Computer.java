package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private final List<Integer> com = new ArrayList<>();

    public void setCom() {  // 상대방의 3자리 숫자를 배열에 저장
        while (com.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!com.contains(randomNumber)) {
                com.add(randomNumber);
            }
        }
    }

    // 상대방의 숫자를 불러옴(Rules.countBallAndStrikes 전용)
    public List<Integer> getCom() {
        return com;
    }

    // 게임 재시작 전 상대방의 숫자를 저장할 배열 비우기
    public void clearCom() {
        com.clear();
    }

}
