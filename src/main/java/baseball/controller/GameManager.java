package baseball.controller;

import baseball.domain.BallNumberGenerator;
import baseball.domain.BallScore;
import baseball.domain.BaseBalls;
import baseball.domain.CompareNumber;
import baseball.domain.DataTypeChanger;
import baseball.domain.GameResult;
import baseball.domain.UserInput;
import baseball.domain.Validator;
import baseball.view.OutputView;
import java.util.List;

public class GameManager {
    private BaseBalls generatedNumber;
    private final BallScore BALL = BallScore.BALL;
    private final BallScore STRIKE = BallScore.STRIKE;

    public GameManager() {
        OutputView.printStartMessage();
    }

    public void startGame() {
        List<Integer> generate  = new BallNumberGenerator().generateBallNumber();
        generatedNumber = new BaseBalls(DataTypeChanger.compareNumberFormat(generate));
        inputNumber();
    }

    private void inputNumber() {
        boolean process = true;
        Validator validator = new Validator();
        while (process) {
            OutputView.printInputNumber();
            List<String> userBalls = UserInput.inputGameNumber(validator);
            process = compareNumbers(DataTypeChanger.compareStringNumberFormat(userBalls));
        }
        endOrRestart();
    }

    private boolean compareNumbers(List<CompareNumber> userBalls) {
        GameResult compare = generatedNumber.compare(userBalls);
        return isEnd(compare);
    }

    private boolean isEnd(GameResult compare) {
        if (compare.getResult(STRIKE) != 3) {
            OutputView.printScore(compare);
            return true;
        }
        if (compare.getResult(STRIKE) == 3) {
            OutputView.printScore(compare);
            OutputView.printGameEnd();
        }
        return false;
    }

    private void endOrRestart() {
        int option = UserInput.endOrRestart(new Validator());
        if (option == 1) {
            startGame();
        }
        if (option == 2) {
            OutputView.printEnd();
        }
    }


}
