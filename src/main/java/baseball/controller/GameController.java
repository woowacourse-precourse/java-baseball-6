package baseball.controller;

import baseball.model.ComputerNumbers;
import baseball.model.Constant;
import baseball.model.Game;
import baseball.view.RestartInput;
import baseball.view.UserNumbers;
import camp.nextstep.edu.missionutils.Console;

public class GameController {


    private void startMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private String getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    private boolean isGameEnd(String result) {
        return result.equals(Constant.END_GAME);
    }

    private void endGameMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private int restartOrEndGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        RestartInput restartInput = new RestartInput(Console.readLine());
        return restartInput.getRestartInput();
    }

    private boolean playRound(ComputerNumbers generator) {
        String input = getUserInput();
        UserNumbers userNumbers = new UserNumbers(input);
        Game game = new Game(generator, userNumbers);
        String result = game.play();
        System.out.println(result);

        if (isGameEnd(result)) {
            return handleGame(generator);
        }
        return true;
    }

    private boolean handleGame(ComputerNumbers generator) {
        endGameMessage();
        int next = restartOrEndGame();
        if (next == Constant.GOING) {
            generator.reset();
            return true;
        }
        return false;
    }

    public void run() {
        ComputerNumbers generator = new ComputerNumbers();

        startMessage();
        while (true) {
            boolean continueGame = playRound(generator);
            if (!continueGame) {
                break;
            }
        }
    }

}
