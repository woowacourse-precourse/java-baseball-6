package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameOver {
    private final String RESTART = "1";
    private final String EXIT = "2";

    GameOver() {

    }

    public void print() {
        printGameOver();
        String number = Console.readLine();
        if (number.equals(EXIT)) {
            exit();
        }
        BaseBallGame baseBallGame = new BaseBallGame();
        baseBallGame.start();
    }

    void printGameOver() {
        System.out.println("3스트라이크");
        System.out.print("3개의 숫자를 모두 맞히셨습니다! ");
        System.out.println("게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    void exit() {
        System.out.print("게임 종료");
        System.exit(0);
    }
}
