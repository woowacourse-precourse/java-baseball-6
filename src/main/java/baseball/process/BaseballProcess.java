package baseball.process;

import baseball.constant.ApplicationConstant;
import baseball.util.BaseballUtil;
import baseball.util.InputUtil;
import baseball.util.RandomUtil;

import java.util.List;

public class BaseballProcess {

    private final RandomUtil randomNumber = RandomUtil.of();
    private final InputUtil inputNumber = InputUtil.of();
    private final BaseballUtil baseball = BaseballUtil.of();

    private BaseballProcess() {
    }

    public static BaseballProcess of() {
        return new BaseballProcess();
    }
    public void start() {
        System.out.print(ApplicationConstant.START_GAME_MESSAGE);
        boolean isCheck = true;
        while (isCheck) {
            playRound();
            int status = inputNumber.inputStatus();
            isCheck = isRestart(status);
        }
    }

    public void playRound() {
        List<Integer> computer = randomNumber.getRandomNumber();
        boolean isCheck = true;
        while (isCheck) {
            List<Integer> player = inputNumber.inputNumber();
            baseball.getBaseballCount(computer, player);
            baseball.printResult();
            isCheck = isContinue(computer, player);
        }
    }

    public boolean isContinue(List<Integer> computer, List<Integer> player) {
        int strike = baseball.getStrikeCount(computer, player);
        if (strike == 3) {
            System.out.print(ApplicationConstant.FINISH_ROUND_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean isRestart(int status) {
        if (status == 1) {
            return true;
        }
        return false;
    }
}
