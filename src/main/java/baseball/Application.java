package baseball;

import camp.nextstep.edu.missionutils.Console;

/**
 * 게임을 시작하고 종료
 */
public class Application {
    private static final int RESTART_OPTION = 1;
    private static final int EXIT_OPTION = 2;

    public static void main(String[] args) {

        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            GameController game = new GameController();
            game.startGame();
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

            int nextGame = askNextGame();
            if (nextGame == EXIT_OPTION) {
                break;
            }
        }
    }

    /**
     * 다음 게임 여부를 물어보고 선택 옵션 반환
     *
     * @return 사용자의 선택 (1: 재시작, 2: 종료)
     */
    private static int askNextGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int nextGame = Integer.parseInt(Console.readLine());
        if (nextGame != RESTART_OPTION && nextGame != EXIT_OPTION) {
            throw new IllegalArgumentException("입력 오류");
        }
        return nextGame;
    }
}
