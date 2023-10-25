package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameManager {
    private Catcher catcher;
    private Pitcher pitcher;
    private Referee referee;

    public GameManager() {
        this.catcher = new Catcher();
        this.pitcher = new Pitcher();
        this.referee = new Referee();
    }

    public void playGame() {
        while(true) {
            displayGameStart();
            catcher.generateRandomNumbers();

            while (true) {
                pitcher.getPlayerInput();

                GameResult gameResult = referee.judgeGameResult(catcher.getNumbers(), pitcher.getNumbers());
                System.out.println(gameResult);

                if (gameResult.isStrikeOut()) {
                    displayGameEnd();
                    break;
                }
            }

            String choice = askForRestart();
            if (choice.equals(Constant.EXIT)) {
                break;
            }
        }
    }

    public void displayGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void displayGameEnd() {
        System.out.println(Constant.MAX_NUMBER_SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public String askForRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }
}
