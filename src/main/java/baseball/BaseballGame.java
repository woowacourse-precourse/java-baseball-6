package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseballGame {

    private int[] answer = new int[3];
    private boolean isWin;

    //게임을 생성합니다.
    public BaseballGame() {
        this.answer = generateAnswer();
        this.isWin = false;
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

    //게임을 실행합니다.
    public void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            int[] userAnswer = new int[3];
            int index;
            System.out.print("숫자를 입력해주세요 : ");
            try {
                userAnswer[0] = Integer.parseInt(Console.readLine());
                for (int i=1; i<2; i++) {
                    index = Integer.parseInt(Console.readLine());
                    if (checkNums(userAnswer, index) == false) {
                        throw new IllegalArgumentException ();
                    }
                }
            } catch (IllegalArgumentException e) {
                break;
            }
            if (checkAnswer(this.answer, userAnswer)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }
        }
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

    //컴퓨터의 답과 사용자의 입력 값을 비교합니다.
    public boolean checkAnswer(int[] answer, int[] userAnswer) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i=0; i<2; i++) {
            if (answer[i] == userAnswer[i]) {
                strikeCount++;
            }

            for (int j=0; j<2; j++) {
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

        if (strikeCount >0) {
            System.out.println(strikeCount+"스트라이크");
        }

        if (strikeCount == 0 && ballCount == 0 ){
            System.out.println("낫싱");
        }

        return false;

    }
}
