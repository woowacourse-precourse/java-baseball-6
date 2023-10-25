package baseball.controller;

import baseball.domain.BallNumberGenerator;
import baseball.domain.BallScore;
import baseball.domain.BaseBalls;
import baseball.domain.CompareNumber;
import baseball.domain.DataTypeChanger;
import baseball.domain.GameResult;
import baseball.domain.UserInput;
import baseball.domain.UserNumber;
import baseball.domain.Validator;
import baseball.view.OutputView;
import java.util.List;

public class GameManager {
    public static final int MAX_SCORE = 3;
    public static final int RESTART = 1;
    public static final BallScore STRIKE = BallScore.STRIKE;
    private BaseBalls generatedNumber;

    public GameManager() {
        OutputView.printStartMessage();
    }

    public void startGame() {
        boolean process = true;
        List<Integer> generate = new BallNumberGenerator().generateBallNumber();
        generatedNumber = new BaseBalls(DataTypeChanger.compareNumberFormat(generate));
        inputNumber(process);
    }

    private void inputNumber(boolean process) {
        Validator validator = new Validator();
        while (process) {
            OutputView.printInputNumber();
            List<String> userBalls = UserInput.inputGameNumber(validator);
            process = compareNumbers(DataTypeChanger.compareStringNumberFormat(userBalls));
        }
        endOrRestart();
    }

    private boolean compareNumbers(List<CompareNumber> userBalls) {
        UserNumber userNumber = new UserNumber(userBalls);
        GameResult compare = generatedNumber.compare(userNumber);
        return isEnd(compare);
    }

    private boolean isEnd(GameResult compare) {
        if (compare.getResult(STRIKE) == MAX_SCORE) {
            OutputView.printScore(compare);
            OutputView.printGameEnd();
            return false;
        }
        OutputView.printScore(compare);
        return true;
    }

    private void endOrRestart() {
        int option = UserInput.endOrRestart(new Validator());
        if (option == RESTART) {
            startGame();
        }
    }


}
