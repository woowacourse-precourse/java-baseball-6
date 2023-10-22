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
            printStrikeBallCount(strikeBallArray);
            if (isSuccess(strikeBallArray)) {
                break;
            }
        }
    }

    private boolean isSuccess(int[] strikeBallArray) {
        if (strikeBallArray[0] == LENGTH) {
            return true;
        }
        return false;
    }

    private void printStrikeBallCount(int[] strikeBallArray) {
        if (strikeBallArray[0] == LENGTH) {
            System.out.println(strikeBallArray[0] + "스트라이크");
            System.out.println(LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return;
        }

        if (strikeBallArray[0] == 0) {
            if (strikeBallArray[1] == 0) {
                System.out.println("낫싱");
            } else {
                System.out.println(strikeBallArray[1] + "볼");
            }
        } else {
            if (strikeBallArray[1] == 0) {
                System.out.println(strikeBallArray[0] + "스트라이크");
            } else {
                System.out.println(strikeBallArray[1] + "볼 " + strikeBallArray[1] + "스트라이크");
            }
        }
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
