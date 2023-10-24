package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameClient {
    private final String MENU_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void runGame() {
        do {
            Game game = new BaseballGame();
            game.play();
        } while (isRestart());
    }

    private boolean isRestart() {
        System.out.println(MENU_MESSAGE);
        String userInput = Console.readLine();
        if (userInput.equals("1")) {
            return true;
        } else if (userInput.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
        }
    }
}
