package baseball.view;

import baseball.BallResult;

public class OutView {
    public static void gameStartPrint() {
        System.out.println("[컴퓨터] : 게임을 시작합니다.");
    }

    public static void numberInputPrint() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void ballScoringResultsPrint(BallResult ballResult) {
        System.out.println(ballResult.toString());
        int b = ballResult.getBall();
        int s = ballResult.getStrike();

        if (b == 0 && s == 0) {
            System.out.println("낫싱");
        } else if (b > 0 && s > 0) {
            System.out.printf("%d볼 %d스트라이크\n",b,s);
        } else if (b == 0 && s > 0) {
            System.out.printf("%d스트라이크\n",s);
        } else if (b > 0 && s == 0) {
            System.out.printf("%d볼\n",b);
        }
    }

    public static void endGamePrint() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void restartGamePrint() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
