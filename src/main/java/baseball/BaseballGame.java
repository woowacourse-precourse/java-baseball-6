package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseballGame {

    private int[] answer = new int[3];

    //게임을 생성 합니다.
    public BaseballGame() {
        this.answer = generateAnswer();
    }

    //정답을 생성 합니다.
    public int[] generateAnswer() {
        int[] newAnswer = new int[3];
        int index;

        newAnswer[0] = Randoms.pickNumberInRange(1, 9);

        for (int i = 0; i < 2; i++) {
            do {
                index = Randoms.pickNumberInRange(0, 9);
            } while (checkNums(newAnswer, index));
            newAnswer[i + 1] = index;
        }
        return newAnswer;
    }

    //게임을 실행 합니다.
    public void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            int[] userAnswer = new int[3];
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            if (input.length() != 3) {
                throw new IllegalArgumentException();
            }
            for (int i = 0; i < 3; i++) {
                char index = input.charAt(i);
                if (checkNums(userAnswer, Character.getNumericValue(index))) {
                    throw new IllegalArgumentException();
                }
                userAnswer[i] = Character.getNumericValue(index);
            }
            if (checkAnswer(this.answer, userAnswer)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                if (!restart()) {
                    break;
                }
            }
        }
        Console.close();
    }

    //재시작 분기 처리를 진행 합니다.
    public boolean restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        int restart = Integer.parseInt(Console.readLine());
        if (restart != 1 && restart != 2) {
            throw new IllegalArgumentException();
        } else if (restart == 1) {
            this.answer = generateAnswer();
            return true;
        }

        return false;
    }

    //서로 다른 수인지 검사 합니다.
    public boolean checkNums(int[] nums, int num) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                return true;
            }
        }
        return false;
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
