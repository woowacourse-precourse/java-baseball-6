package baseball.logic;

import baseball.user.User;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    private final User user;
    private BaseballRule rule;

    private boolean isSuccess = false;


    public BaseballGame() {
        user = new User();
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
        System.out.println("숫자 야구 게임을 시작합니다.");
    }



    private List<Integer> makeBaseBallNumber() {
        List<Integer> baseBallNumber = new ArrayList<>();

        while (baseBallNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!baseBallNumber.contains(randomNumber)) {
                baseBallNumber.add(randomNumber);
            }
        }

        return baseBallNumber;
    }


    private boolean doUserTurn() {
        ArrayList<Integer> userBaseBallNum = user.inputNumber();
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
