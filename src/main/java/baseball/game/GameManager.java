package baseball.game;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameManager {
    private final BaseballGame baseballGame = new BaseballGame();

    public void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        do {
            baseballGame.play();
            
        } while (shouldContinueGame());
    }

    private boolean shouldContinueGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = readLine();
        if (userInput.equals("1")) {
            return true;
        }
        if (userInput.equals("2")) {
            return false;
        }

        throw new IllegalArgumentException();
    }
}
