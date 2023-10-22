package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseBall {
    private final int LENGTH = 3;
    private Computer computer;

    public BaseBall() {
        computer = new Computer();
        computer.createComputerNumber(LENGTH);
    }

    public void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            int[] strikeBallArray = new int[2];
            String inputNumber = Console.readLine();
            PlayerNumber playerNumber = new PlayerNumber(inputNumber, LENGTH);
            countStrikeBall(strikeBallArray, playerNumber);

            if (isSuccess(strikeBallArray)) {
                Notification.notifySuccessResult(strikeBallArray);
                break;
            }
            Notification.notifyFailResult(strikeBallArray);
        }
    }

    private boolean isSuccess(int[] strikeBallArray) {
        if (strikeBallArray[0] == LENGTH) {
            return true;
        }
        return false;
    }

    private void countStrikeBall(int[] strikeBallCount, PlayerNumber playerNumber) {
        for (int i = 0; i < LENGTH; i++) {
            int cur = playerNumber.get(i) - '0';
            if (computer.get(i) == cur) {
                strikeBallCount[0]++;
            } else if (computer.contains(cur)) {
                strikeBallCount[1]++;
            }
        }
    }
}
