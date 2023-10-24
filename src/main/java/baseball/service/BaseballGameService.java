package baseball.service;

import baseball.domain.Answer;
import baseball.domain.Game;
import baseball.domain.User;
import baseball.domain.status.GameStatus;
import baseball.exception.NotRestartAndFinishException;
import baseball.utils.PrintUtils;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGameService {
    private Answer answer;
    private User user;

    public BaseballGameService() {
        this.user = new User();
        this.answer = new Answer();
    }

    public void settingGame() {
        answer.generateRandomNumbers();
    }

    public void inputNumber() {
        String number = readConsole();
        user.setInput(number);
    }

    public void start() {
        while (true) {
            PrintUtils.printInputUserNumber();
            inputNumber();
            Game game = new Game(answer.getAnswerNumbers(), user.getInput());
            PrintUtils.printResult(game);
            if (game.isAnswer()) {
                PrintUtils.printEndGame();
                break;
            }
        }
    }

    private String readConsole() {
        return Console.readLine();
    }


    public boolean selectRestartOrFinish() {
        String number = readConsole();
        validateRestartOrFinishNumber(number);
        return number.equals(GameStatus.RESTART.getStatus());
    }

    private void validateRestartOrFinishNumber(String enterPlayerNumber) {
        if (!enterPlayerNumber.equals(GameStatus.RESTART.getStatus()) && !enterPlayerNumber.equals(
                GameStatus.FINISH.getStatus())) {
            throw new NotRestartAndFinishException();
        }
    }

    public boolean isRestart() {
        PrintUtils.printRestartOrFinishGameMessage();
        return selectRestartOrFinish();
    }
}
