package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballGame {

    private int[] answer = new int[3];

    //게임을 생성합니다.
    public BaseballGame() {
        this.answer = generateAnswer();
    }

    //정답을 생성합니다.
    public int[] generateAnswer() {
        int[] newAnswer = new int[3];
        int index;

        newAnswer[0] = Randoms.pickNumberInRange(1, 9);

        for (int i = 0; i<2; i++) {
            do {
                index = Randoms.pickNumberInRange(0, 9);
            } while (checkNums(newAnswer, i));
            newAnswer[i + 1] = index;
        }
        return newAnswer;
    }

    //서로 다른 수인지 검사합니다.
    public boolean checkNums(int[] nums, int num) {
        for (int index : nums) {
            if (index == num) {
                return false;
            }
        }
        return true;
    }
}
