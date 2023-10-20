package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumberBaseballGame {

    private List<Integer> goalNum = new ArrayList<>();  // 목표 숫자(정답)

    public NumberBaseballGame() {
        goalNum.clear();

        // 랜덤 숫자 생성
        while (goalNum.size() < 3) {
            int randNum = Randoms.pickNumberInRange(1, 9);

            if (!goalNum.contains(randNum)) {
                goalNum.add(randNum);
            }
        }
    }

    // 야구 게임 로직
    public int[] startGame(List<Integer> num) {
        // 0번째 인덱스: 볼의 개수
        // 1번째 인덱스: 스트라이크의 개수
        int[] result = new int[2];

        for (int i = 0; i < 3; i++) {
            if (num.contains(goalNum.get(i))) {
                // 서로 같은 자리에 있다면
                if (num.get(i) == goalNum.get(i)) {
                    // 스트라이크 수 증가
                    result[1]++;
                }
                // 다른 자리에 있다면
                else {
                    // 볼 수 증가
                    result[0]++;
                }
            }
        }

        return result;
    }
}
