package baseball.Controller;

import baseball.Model.GameService;
import baseball.Model.Referee;
import baseball.Util.Parser;
import baseball.View.InputView;
import baseball.View.OutputView;

import java.util.Map;

public class GameController {

    public static final String RESTART = "1";
    GameService gameService = new GameService();

    public void run() {
        setGame();
        playGame();
        restartOrExitGame();
    }

    private void setGame() {
        gameService.readyGame();
        OutputView.printStartMessage();
    }

    private void playGame() {
        boolean isCorrect = false;
        while(!isCorrect) {
            String input = InputView.requestInputNumbers();
            Map<String, Integer> result = gameService.playRound(Parser.convertStringToArrayList(input));
            OutputView.printJudgement(result);
            isCorrect = isThreeStrike(result);
        }
        OutputView.printCorrectMessage();
        OutputView.printEndMessage();
    }

    private boolean isThreeStrike(Map<String, Integer> result) {
        return result.get(Referee.STRIKE) == 3;
    }

    private void restartOrExitGame() {
        String input = InputView.requestRestartOrExit();
        if (input.equals(RESTART)) {
            run();
        }
    }
}
