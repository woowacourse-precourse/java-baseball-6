package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.model.UserNumber;
import baseball.service.GameResultService;
import baseball.model.PlayAgainDecision;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameController {
    public static GameController instance = new GameController();
    private GameResultService gameResultService;

    private GameController() {
    }

    public static GameController getInstance() {
        return instance;
    }

    public void run() {
        boolean continuePlaying = true;
        while (continuePlaying) {
            continuePlaying = play();
        }
    }

    private boolean play() {
        OutputView.printStart();
        ComputerNumber computerNumber = createComputerNumber();

        boolean needsNextRound = true;
        while (needsNextRound) {
            needsNextRound = playRound(computerNumber);
        }
        return wantsRestart();
    }

    private ComputerNumber createComputerNumber() {
        return ComputerNumber.create();
    }

    private boolean playRound(ComputerNumber computerNumber) {
        UserNumber userNumber = readUserNumber();
        //computerNumber, userNumber 가 최대한 일을 하게 하자. 그리고 둘이 같이 필요한 경우 GameResultService 이용
        GameResultService gameResultService = GameResultService.of(computerNumber, userNumber);
        OutputView.printResult(gameResultService.isNothing(), gameResultService.getBallCount(), gameResultService.getStrikeCount());
        return !gameResultService.isThreeStrike();
    }

    private static UserNumber readUserNumber() {
        List<Integer> numbers = InputView.readUserNumber();
        return UserNumber.from(numbers);
    }

    private static boolean wantsRestart() {
        OutputView.printEnd();
        PlayAgainDecision playAgainDecision = readPlayAgainInput();
        return playAgainDecision.isAgain();
    }

    private static PlayAgainDecision readPlayAgainInput() {
        int input = InputView.readPlayAgainInput();
        return PlayAgainDecision.of(input);
    }
}
