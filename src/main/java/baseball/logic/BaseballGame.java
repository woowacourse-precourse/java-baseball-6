package baseball.logic;

import baseball.locales.GameScripts;
import baseball.user.User;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    private final int ballLength;
    private final User user;
    private BaseballRule rule;

    private boolean isSuccess = false;


    public BaseballGame(int ballLength) {
        user = new User();
        this.ballLength = ballLength;
        reset();
    }


    public void run() {
        while (true) {
            boolean keepRun = doUserTurn();
            if (!keepRun) {
                return;
            }

            handleSuccess();
        }
    }

    private void handleSuccess() {
        if (isSuccess) {
            reset();
        }
    }

    private void reset() {
        printHello();

        isSuccess = false;
        List<Integer> answerNumber = makeBaseBallNumber();
        rule = new BaseballRule(answerNumber);
    }

    private void printHello() {
        System.out.println(GameScripts.GAME_START);
    }


    private List<Integer> makeBaseBallNumber() {
        List<Integer> baseBallNumber = new ArrayList<>();

        while (baseBallNumber.size() < ballLength) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!baseBallNumber.contains(randomNumber)) {
                baseBallNumber.add(randomNumber);
            }
        }

        return baseBallNumber;
    }


    private boolean doUserTurn() {
        List<Integer> userBaseBallNum = user.inputNumber(ballLength);
        BaseballResult result = rule.checkBaseball(userBaseBallNum);
        result.printStatus();

        if (result.isSuccess()) {
            result.printSuccess();
            isSuccess = true;
            return user.checkRestart();
        }

        return true;
    }


}
