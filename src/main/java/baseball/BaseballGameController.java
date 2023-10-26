package baseball;
// BaseballGameController.java (Controller 클래스)
// BaseballGameController.java (Controller 클래스)

import camp.nextstep.edu.missionutils.Console;

public class BaseballGameController {
    private BaseballGameService gameService;


    public BaseballGameController() {
        gameService = new BaseballGameService();
    }

    public void runGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            gameService.playGame();

            if (!wantsToRestart()) {
                break;
            }
        }
    }

    private boolean wantsToRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String choice = Console.readLine();
        return "1".equals(choice);
    }
}
