package baseball;

import java.util.Scanner;

public class BaseballGame {

    private static final Scanner SCANNER = new Scanner(System.in);
    private Computer computer;

    public BaseballGame() {
        this.computer = ComputerFactory.createComputer();
    }

    private void resetGame() {
        this.computer = ComputerFactory.createComputer();
    }

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            try {
                BaseballNumbers userNumbers = BaseballNumbers.fromInput(getUserInputString());
                GameResult result = computer.guess(userNumbers);

                System.out.println(result);

                if (result.isGameWon()) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    if (!askToPlayAgain()) {
                        break;
                    }
                }

            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
            }
        }
    }

    private String getUserInputString() {
        System.out.print("숫자를 입력해주세요 : ");
        return SCANNER.nextLine();
    }

    private boolean askToPlayAgain() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
        int choice = Integer.parseInt(SCANNER.nextLine());
        if (choice == 1) {
            resetGame();
            return true;
        }
        return false;
    }

    private static class ComputerFactory {
        static Computer createComputer() {
            return new Computer();
        }
    }
}
