package baseball.run;

import baseball.service.BaseBallCompare;
import baseball.view.BaseBallView;
import baseball.vo.InputNumbers;

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
        baseBallCompare.setRandomNumbers();

        if (playBaseBallGame()) {
            String inputStr = baseBallView.endGame();

            if (restartCheck(inputStr)) {
                startGame();
            }
        }
    }

    public boolean playBaseBallGame() {
        InputNumbers inputNumbers = new InputNumbers(baseBallView.inputNumber());
        if (baseBallCompare.compare(inputNumbers)) {

            baseBallView.outputResult(baseBallCompare.getResultMessage());
            return true;
        }
        baseBallView.outputResult(baseBallCompare.getResultMessage());

        return playBaseBallGame();
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
