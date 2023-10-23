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
            System.out.println(BaseballUtil.STRIKE_BALL[result.getStrike()][result.getBall()]);
            if (result.getStrike() == BaseballUtil.MAX) {
                return;
            }
        }
    }

    private List<Integer> getInputNumberList() {
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
