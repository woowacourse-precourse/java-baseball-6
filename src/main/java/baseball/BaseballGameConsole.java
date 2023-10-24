package baseball;

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
        System.out.println("숫자 야구 게임을 시작합니다.");
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
        System.out.print("숫자를 입력해주세요 : ");
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
            System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n", NumberConstants.SIZE);
            strikeOut = true;
        }
    }

    private void checkContinue() {
        System.out.printf("게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.\n", NumberConstants.START_NUM, NumberConstants.END_NUM);
        String continueAnswer = Console.readLine();

        validator.checkValidAnswer(continueAnswer);

        if (Integer.toString(NumberConstants.END_NUM).equals(continueAnswer)) {
            isContinue = false;
        }
    }
}
