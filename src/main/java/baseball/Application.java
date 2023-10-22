package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final int RESTART_GAME = 1;
    private static final int EXIT_GAME = 2;

    public static void main(String[] args) {

        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            GameController game = new GameController();
            game.startGame();
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

            int nextGame = askNextGame();
            if (nextGame == EXIT_GAME) {
                break;
            }
        }
    }

    private static int askNextGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int nextGame = Integer.parseInt(Console.readLine());
        if (nextGame != RESTART_GAME && nextGame != EXIT_GAME) {
            throw new IllegalArgumentException("입력 오류");
        }
        return nextGame;
    }
}
