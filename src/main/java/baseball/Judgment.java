package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Judgment {
    public int[] countMatchingNumbers(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            int playerDigit = playerNumbers.get(i);
            int computerDigit = computerNumbers.get(i);
            if (playerDigit == computerDigit) {
                strike++;
            } else if (computerNumbers.contains(playerDigit)) {
                ball++;
            }
        }
        return new int[]{strike, ball};
    }

    public void printHint(int strike, int ball) {
        StringBuilder output = new StringBuilder();
        if (strike == 3) {
            output.append(strike).append("스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println(output.toString());
        } else {
            if (ball > 0) {
                output.append(ball).append("볼 ");
            }
            if (strike > 0 && strike < 3) {
                output.append(strike).append("스트라이크");
            }
            if (output.isEmpty()) {
                System.out.println("낫싱");
            } else {
                System.out.println(output.toString().trim());
            }
        }
    }

    public boolean askForRestartOrExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userChoice= Console.readLine();
        return userChoice.equals("1");
    }
}
