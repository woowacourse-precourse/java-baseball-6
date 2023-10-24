package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Computer {
    private static ArrayList<Integer> answerNumber = new ArrayList<>();

    private void returnResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else {
            String strikeResult = "";
            String ballResult = "";
            if (strike > 0) {
                strikeResult = strike + "스트라이크";
            }
            if (ball > 0) {
                ballResult = ball + "볼";
                strikeResult = " " + strikeResult;
            }
            System.out.println(ballResult + strikeResult);
        }
        Player player = new Player();
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            player.restartOrEnd();
        } else {
            player.input();
        }
    }

    public void checkScore(ArrayList<Integer> inputNumber) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < answerNumber.size(); i++) {
            Integer num = answerNumber.get(i);
            if (inputNumber.contains(num)) {
                if (inputNumber.indexOf(num) == i) {
                    strike++;
                } else {
                    ball++;
                }
            }
        }
        returnResult(strike, ball);
    }

    public void createRandomNumber() {
        answerNumber.clear();
        while (answerNumber.size() != 3) {
            Integer num = Randoms.pickNumberInRange(1, 9);
            if (!answerNumber.contains(num)) {
                answerNumber.add(num);
            }
        }
    }
}