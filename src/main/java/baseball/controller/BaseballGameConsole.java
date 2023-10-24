package baseball.controller;

import baseball.constants.NumberConstants;
import baseball.model.BallCount;
import baseball.views.GameView;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGameConsole {
    private Validator validator = Validator.getInstance();
    private GameView gameView = GameView.getInstance();
    private boolean isContinue;
    private List<Integer> hitterSelection;
    private String pitcherSelection;
    private BallCount ballCount;
    private boolean strikeOut;


    public void start() {
        gameView.start();
        isContinue = true;

        while (isContinue) {
            play();
            checkContinue();
        }
    }

    private void play() {
        strikeOut = false;
        generateHitterSelection();

        while (!strikeOut) {
            getPitcherSelection();
            getBallCount();
            printBallCount();
            checkStrikeOut();
        }
    }

    private void generateHitterSelection() {
        hitterSelection = new ArrayList<>();

        while (hitterSelection.size() < NumberConstants.SIZE) {
            int randomNumber = Randoms.pickNumberInRange(NumberConstants.MIN, NumberConstants.MAX);
            if (!hitterSelection.contains(randomNumber)) {
                hitterSelection.add(randomNumber);
            }
        }
    }

    private void getPitcherSelection() {
        gameView.requestNumbersInput();
        pitcherSelection = Console.readLine();

        validator.checkValidInput(pitcherSelection);
    }

    private void getBallCount() {
        ballCount = new BallCount();

        for (int i = 0; i < pitcherSelection.length(); i++) {
            char numChar = pitcherSelection.charAt(i);
            int num = Character.getNumericValue(numChar);

            if (num == hitterSelection.get(i)) {
                ballCount.addStrike();
            } else if (hitterSelection.contains(num)) {
                ballCount.addBall();
            }
        }
    }

    private void printBallCount() {
        if (ballCount.getStrike() == 0 && ballCount.getBall() == 0) {
            gameView.gameResult();
        } else {
            String result = "";
            if (ballCount.getBall() > 0) {
                result = ballCount.getBall() + "볼";
            }
            if (ballCount.getStrike() > 0) {
                result += (result.isEmpty() ? "" : " ") + ballCount.getStrike() + "스트라이크";
            }
            gameView.gameResult(result);
        }
    }

    private void checkStrikeOut() {
        if (ballCount.getStrike() == NumberConstants.SIZE) {
            gameView.end();
            strikeOut = true;
        }
    }

    private void checkContinue() {
        gameView.requestRestartInput();
        String continueAnswer = Console.readLine();

        validator.checkValidAnswer(continueAnswer);

        if (Integer.toString(NumberConstants.END_NUM).equals(continueAnswer)) {
            isContinue = false;
        }
    }
}
