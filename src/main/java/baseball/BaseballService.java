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
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return;
            }
        }
    }

    public boolean isRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restartNumber = Console.readLine();
        if (!"1".equals(restartNumber) && !"2".equals(restartNumber)) {
            throw new IllegalArgumentException();
        }

        return "1".equals(restartNumber);
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
