package baseball.view;

import java.util.ArrayList;
import java.util.List;

public class judgeView {
    static boolean temp;

    public void judgeBaseball(String computer, List<Integer> user) {
        int strike = 0;
        int ball = 0;
        temp = false;
        ArrayList<Integer> computerNum = new ArrayList<>();

        for (char com : computer.toCharArray()) {
            computerNum.add(Character.getNumericValue(com));
        }

        for (int i = 0; i < computerNum.size(); i++) {
            for (int j = 0; j < user.size(); j++) {
                if (computerNum.get(j) == user.get(j) && i == j) {
                    strike++;
                }
                if (computerNum.get(i) == user.get(j) && i != j) {
                    ball++;
                }
            }
        }

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
        if (ball != 0 && strike == 0) {
            System.out.println(ball + "볼");
        }
        if (ball == 0 && strike != 0) {
            System.out.println(strike + "스트라이크");
            temp = true;
        }
        if (ball != 0 && strike != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

    public boolean countThreeStrike() {
        return temp;
    }

    public void victoryScore() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
