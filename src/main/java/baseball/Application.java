// BaseballGame.java
package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            Computer computer = new Computer();
            List<Integer> computerNumbers = computer.generateRandomNumbers();

            while (true) {
                UserInput userInput = new UserInput();
                List<Integer> userNumbers = userInput.getUserInput();

                GameResult result = GameResult.calculateResult(computerNumbers, userNumbers);
                result.printResult();

                if (result.isGameEnd()) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
            String playAgainInput = Console.readLine();

            if (playAgainInput.equals("2")) {
                System.out.println("게임을 종료합니다.");
                return; //1 선택시 루프 반복
            }
        }
    }
}
