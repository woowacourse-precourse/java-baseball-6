package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseBall {
    private final int LENGTH = 3;

    public void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        Computer computer = new Computer();
        computer.createComputerNumber(LENGTH);

        while (true) {
            int strike = 0;
            int ball = 0;
            String inputNumber = Console.readLine();
            PlayerNumber playerNumber = new PlayerNumber(inputNumber, LENGTH);

            for (int i = 0; i < LENGTH; i++) {
                int cur = playerNumber.get(i) - '0';
                if (computer.get(i) == cur) {
                    strike++;
                } else if (computer.contains(cur)) {
                    ball++;
                }
            }

            if (strike == LENGTH) {
                System.out.println(strike + "스트라이크");
                System.out.println(LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                break;
            }

            if (strike == 0) {
                if (ball == 0) {
                    System.out.println("낫싱");
                } else {
                    System.out.println(ball + "볼");
                }
            } else {
                if (ball == 0) {
                    System.out.println(strike + "스트라이크");
                } else {
                    System.out.println(ball + "볼 " + strike + "스트라이크");
                }
            }
        }
    }
}
