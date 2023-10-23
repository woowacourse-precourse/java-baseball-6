package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballGame {

    private int answer;

    //게임을 생성합니다.
    public BaseballGame() {
        this.answer = generateAnswer();
    }

    public int generateAnswer() {
        return Randoms.pickNumberInRange(1, 9)*100 + Randoms.pickNumberInRange(1, 9)*10
                + Randoms.pickNumberInRange(1, 9);
    }
}
