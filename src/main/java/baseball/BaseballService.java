package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class BaseballService {

    private final Computer computer;

    public BaseballService() {
        computer = new Computer();
    }

    private void setComputerNumber() {
        computer.initNewComputerNumberList();
    }

    public void playGame() {
        setComputerNumber();

        while (true) {
            Result result = computer.compareNumbers(getInputNumberList());
            BaseballUtil.printStrikeBallResult(result.getStrike(), result.getBall());
            if (result.getStrike() == BaseballUtil.MAX) {
                BaseballUtil.printEndGame();
                return;
            }
        }
    }

    public boolean isRestart() {
        BaseballUtil.printRestartGame();

        String restartNumber = Console.readLine();
        if (!"1".equals(restartNumber) && !"2".equals(restartNumber)) {
            throw new IllegalArgumentException();
        }

        return "1".equals(restartNumber);
    }

    private List<Integer> getInputNumberList() {
        BaseballUtil.printInputNumber();

        String input = Console.readLine();
        if (!input.matches(BaseballUtil.REGEX_NUMBER)) {
            throw new IllegalArgumentException();
        }

        List<Integer> inputNumberList = new ArrayList<>();
        for (int i = 0; i < BaseballUtil.MAX; i++) {
            inputNumberList.add(input.charAt(i) - '0');
        }

        return inputNumberList;
    }
}
