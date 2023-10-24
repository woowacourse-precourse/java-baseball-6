package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        printStartStmt();
        startGame();
    }

    /**
     * gameControl Methods
     */
    private static void startGame() {
        boolean restartGame;

        do {
            baseballGame();

            printAskRestartStmt();

            String restartInput = Console.readLine();
            restartGame = restartInput.equals("1");
        } while (restartGame);
    }

    private static void printStartStmt() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }


    private static void printAskRestartStmt() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
