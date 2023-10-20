package baseball.Model;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private int[] answer;

    public Computer() {
        makeAnswer();
    }

    private void makeAnswer() {
        answer = new int[3];
        for(int i = 0; i < 3; ++i) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
        }
    }

    public int[] getAnswer() {
        // 외부에서 변경 방지
        return answer.clone();
    }
}
