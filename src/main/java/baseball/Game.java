package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Game {
    private int computerNumberLength = 0;
    private int continueGameNumber = 1;


    // 게임 시작 & 문제 맞춘 후 계속 게임하고 싶을 때
    public void continueGame() {
        while (continueGameNumber == 1) {
            // 컴퓨터 수 생성
            Computer computer = Computer.createComputerNumber();
            List<Integer> computerNumber = computer.getComputerNumber();
            computerNumberLength = computerNumber.size();
            afterCreateComputerNumberContinueGame(computerNumber);
        }
    }

    // 정답을 맞출 때까지 문제를 풀 때
    private void afterCreateComputerNumberContinueGame(List<Integer> computerNumber) {
        while (computerNumberLength != 0) {
            // 사용자 생성
            User userPlayer = new User();
            String input = userPlayer.getNumber();
            int[] numList = userPlayer.saveUserInput(input);

            // 입력값이 3자리이면서, 서로 다른 수이면서, 각 수가 0이 아닐 때
            if (this.validateInput(input, numList)) {

                int[] ballStrikeNumber = this.calculateStrikeOrBallNumber(computerNumber, numList);
                this.printGameResult(ballStrikeNumber[0], ballStrikeNumber[1]);

            } else {
                throw new IllegalArgumentException();
            }

        }

    }

    // 길이가 3이며, 서로 다른 숫자들이며, 각 숫자들이 0이 아닌지 판단하는 함수
    private boolean validateInput(String input, int[] numList) {
        if (input.length() == 3 && numList[0] != numList[1] && numList[1] != numList[2] && numList[0] != numList[2]
                && numList[0] != 0 && numList[1] != 0 && numList[2] != 0) {
            return true;
        }
        throw new IllegalArgumentException();

    }

    // 스트라이크와 볼이 몇 개인지 구하는 함수
    private int[] calculateStrikeOrBallNumber(List<Integer> computer, int[] numList) {
        int[] ballStrikeNumber = new int[2];
        for (int i = 0; i < 3; i++) {
            if (computer.contains(numList[i])) {
                if (computer.get(i) == numList[i]) {
                    ballStrikeNumber[1]++;
                } else {
                    ballStrikeNumber[0]++;
                }
            }
        }
        return ballStrikeNumber;
    }

    private void printGameResult(int ballNumber, int strikeNumber) {
        if (ballNumber == 0 && strikeNumber == 0) {
            System.out.println("낫싱");
        } else if (strikeNumber == 0) {
            System.out.printf("%d볼 %n", ballNumber);
        } else if (ballNumber == 0) {
            System.out.printf("%d스트라이크 %n", strikeNumber);
            threeStrike(strikeNumber);
        } else {
            System.out.printf("%d볼 %d스트라이크 %n", ballNumber, strikeNumber);
        }
    }

    // 3스트라이크일 때
    private void threeStrike(int strikeNumber) {
        if (strikeNumber == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            wantsToPlayAgain();
            computerNumberLength = 0;
        }
    }

    // 게임을 더하고 싶은지 그만할지 정하는 함수
    private void wantsToPlayAgain() {
        String numInput = Console.readLine();
        if (!numInput.equals("1") && !numInput.equals("2")) {
            throw new IllegalArgumentException();
        } else if (numInput.equals("2")) {
            continueGameNumber = 2;
        }
    }
}
