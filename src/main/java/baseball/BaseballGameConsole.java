package baseball;

import baseball.constants.MessageConstants;
import baseball.constants.NumberConstants;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGameConsole {
    private Validator validator = Validator.getInstance();
    private boolean isContinue;
    private List<Integer> hitterSelection;
    private String pitcherSelection;
    private BallCount ballCount;
    private boolean strikeOut;


    void start() {
        System.out.println(MessageConstants.GAME_START);
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
        System.out.print(MessageConstants.REQUEST_NUMBERS_INPUT);
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
            System.out.println("낫싱");
        } else {
            String message = "";
            if (ballCount.getBall() > 0) {
                message = ballCount.getBall() + "볼";
            }
            if (ballCount.getStrike() > 0) {
                message += (message.isEmpty() ? "" : " ") + ballCount.getStrike() + "스트라이크";
            }
            System.out.println(message);
        }
    }

    private void checkStrikeOut() {
        if (ballCount.getStrike() == NumberConstants.SIZE) {
            System.out.println(MessageConstants.END_GAME);
            strikeOut = true;
        }
    }

    private void checkContinue() {
        System.out.println(MessageConstants.REQUEST_RESTART_INPUT);
        String continueAnswer = Console.readLine();

        validator.checkValidAnswer(continueAnswer);

        if (Integer.toString(NumberConstants.END_NUM).equals(continueAnswer)) {
            isContinue = false;
        }
    }
}
