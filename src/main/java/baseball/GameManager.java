package baseball;

import baseball.view.OutputView;
import java.util.List;

public class GameManager {
    private BaseBalls generatedNumber;
    private final BallScore BALL = BallScore.BALL;
    private final BallScore STRIKE = BallScore.STRIKE;

    public GameManager() {
        OutputView.printStartMessage();
        generatedNumber = new BaseBalls(new BallNumberGenerator().generateBallNumber());
    }

    public void startGame() {
        inputNumber();
    }

    private void inputNumber() {
        boolean process = true;
        Validator validator = new Validator();
        while(process) {
            OutputView.printInputNumber();
            List<String> userBalls = UserInput.inputGameNumber(validator);
            process = compareNumbers(DataTypeChanger.mapToInt(userBalls));
        }

    }

    private boolean compareNumbers(List<Integer> userBalls) {
        GameResult compare = generatedNumber.compare(userBalls);
        return isEnd(compare);
    }

    private boolean isEnd(GameResult compare) {
        if (compare.getResult(STRIKE) != 3) {
            OutputView.printScore(compare.getResult(BALL), compare.getResult(STRIKE));
            return true;
        }
        if (compare.getResult(STRIKE) == 3) {
            OutputView.printScore(compare.getResult(BALL), compare.getResult(STRIKE));
            OutputView.printGameEnd();
        }
        return false;
    }


}
