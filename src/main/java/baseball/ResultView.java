package baseball;

import java.util.List;

public class ResultView {


    public void printEndMessage(List<Integer> BallandStrike) {
        int ball = BallandStrike.get(0);
        int strike = BallandStrike.get(1);

        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");

        }
        if (ball != 0 && strike == 0) {
            System.out.println(ball + "볼");
        }
        if (ball == 0 && strike != 0) {
            System.out.println(strike + "스트라이크");

        }
        if (ball != 0 && strike != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

    public void ThreeStrike() {

        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    }

}
