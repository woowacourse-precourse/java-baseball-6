package baseball;

import baseball.logic.Compare;
import baseball.logic.ComputerCreateRandomNumber;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        ComputerCreateRandomNumber createRandomNumber = new ComputerCreateRandomNumber();
        Compare compare = new Compare();
        Scanner scanner = new Scanner(System.in);

        boolean restartGame = true;

        while (restartGame) {
            int computerInput = createRandomNumber.createRandomNumber();
            boolean correctGuess = false;

            System.out.println("숫자 야구 게임을 시작합니다.");

            while (!correctGuess) {
                System.out.print("숫자를 입력해주세요 : ");
                int userInput = scanner.nextInt();

                String result = compare.getGameResult(computerInput, userInput);
                System.out.println(result);

                if (result.equals("3스트라이크")) {
                    System.out.println("3개의 숫자를 모두 맞혔습니다! 게임 종료");
                    correctGuess = true;
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
            int againGame = scanner.nextInt();

            if (againGame == 2) {
                restartGame = false;
            }
        }
    }
}
