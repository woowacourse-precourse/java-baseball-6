package baseball.baseballGame;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGame {
    private int cnt; // 맞춰야 할 숫자의 개수
    private List<Integer> numbers; // 컴퓨터가 선택한 숫자 담을 리스트

    public BaseBallGame() {
    }

    public BaseBallGame(int cnt) {
        this.cnt = cnt;

        // cnt 만큼 숫자 선택해서 numbers에 추가
        numbers = new ArrayList<>();
        while (numbers.size() < cnt) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }

    public int getCnt() {
        return cnt;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // 숫자 야구 게임 시작
    public void start() {
    }

}
