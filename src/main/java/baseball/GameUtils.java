package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class GameUtils {

    //정답을 생성 합니다.
    public int[] generateAnswer() {
        int[] newAnswer = new int[3];
        int index;

        newAnswer[0] = Randoms.pickNumberInRange(1, 9);

        for (int i = 0; i < 2; i++) {
            do {
                index = Randoms.pickNumberInRange(0, 9);
                newAnswer[i + 1] = index;
            } while (checkNums(newAnswer));

        }
        return newAnswer;
    }

    //서로 다른 수인지 검사 합니다.
    public boolean checkNums(int[] nums) {
        return nums[0] == nums[1] || nums[1] == nums[2] || nums[2] == nums[0];
    }

    //컴퓨터의 답과 사용자의 입력 값을 비교 합니다.
    public boolean checkAnswer(int[] answer, int[] userAnswer) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < 3; i++) {
            if (answer[i] == userAnswer[i]) {
                strikeCount++;
            }

            for (int j = 0; j < 3; j++) {
                if (answer[i] == userAnswer[j] && i != j) {
                    ballCount++;
                }
            }
        }

        if (strikeCount == 3) {
            System.out.println(strikeCount + "스트라이크");
            return true;
        }

        if (ballCount > 0) {
            System.out.print(ballCount + "볼 ");
        }

        if (strikeCount > 0) {
            System.out.print(strikeCount + "스트라이크");
        }

        if (strikeCount == 0 && ballCount == 0) {
            System.out.print("낫싱");
        }

        System.out.println();

        return false;

    }
}
