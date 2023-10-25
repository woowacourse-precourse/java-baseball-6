package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameManager {
    public static void start() {
        printWelcomeMessage();

        while (true) {
            Game game = configureGame();
            game.play();

            printAfterGameMessage();
            AfterGameStatus status = getAfterGameStatus();

            if (status.isExitable()) {
                break;
            }
        }
    }

    private static void printWelcomeMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private static void printAfterGameMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private static Game configureGame() {
        Player player = new Player();
        Questioner questioner = new Questioner();
        return new Game(player, questioner);
    }

    private static AfterGameStatus getAfterGameStatus() {
        String input = Console.readLine();
        return AfterGameStatus.from(input);
    }
}
