package baseball;

import java.util.List;

public class RunGame {
    static Boolean runGame(List<Integer> computer, List<Integer> input) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i).equals(input.get(i))) {
                strike++;
            } else if (computer.contains(input.get(i))) {
                ball++;
            }
        }
        if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        return false;
    }
}