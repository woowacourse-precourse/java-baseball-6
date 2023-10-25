package baseball.view;

import java.util.Scanner;

public class OutputView {

    private static final int NEW_GAME = 1;
    private static final int FINISH = 2;
    private int cmd;
    public boolean playNewGame() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

       cmd = SharedScanner.scanner.nextInt();

        if(cmd == NEW_GAME) return true;
        if(cmd == FINISH) return false;
        throw new IllegalArgumentException();
    }

    public void printResult(int strike, int ball) {
        if(ball != 0) System.out.print(ball + "볼 ");
        if(strike != 0) System.out.print(strike + "스트라이크");
        if(ball == 0 && strike == 0) System.out.print("낫싱");
        System.out.println();
    }
}
