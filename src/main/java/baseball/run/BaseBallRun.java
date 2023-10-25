package baseball.run;

import baseball.compare.BaseBallCompare;
import baseball.view.BaseBallView;
import baseball.vo.InputNumbers;
import baseball.vo.RandomNumbers;

public class BaseBallRun {
    private final BaseBallView baseBallView;
    private final BaseBallCompare baseBallCompare;

    public BaseBallRun() {
        this.baseBallView = new BaseBallView();
        this.baseBallCompare = new BaseBallCompare();
    }

    public void run() {
        baseBallView.startBaseBallGame();
        startGame();
    }

    public void startGame() {
        RandomNumbers randomNumbers = new RandomNumbers();

        if (playBaseBallGame(randomNumbers)) {
            String inputStr = baseBallView.endGame();

            if (restartCheck(inputStr)) {
                startGame();
            }
        }
    }

    public boolean playBaseBallGame(RandomNumbers randomNumbers) {
        InputNumbers inputNumbers = new InputNumbers(baseBallView.inputNumber());
        if (baseBallCompare.compare(randomNumbers, inputNumbers)) {

            baseBallView.outputResult(baseBallCompare.getResultMessage());
            return true;
        }
        baseBallView.outputResult(baseBallCompare.getResultMessage());

        return playBaseBallGame(randomNumbers);
    }

    private boolean restartCheck(String inputStr) {
        if (inputStr.equals("1")) {
            return true;
        }

        if (inputStr.equals("2")) {
            return false;
        }

        throw new IllegalArgumentException();
    }
}
