package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GameService {
    Computer computer = new Computer();
    User user = new User();

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean playAgain = true;
        while (playAgain) {
            playGame();
            playAgain = replay();
        }

        System.out.println("게임을 종료합니다. 안녕히 가세요!");
    }

    private void playGame() {

        computer.setComputerNumber();
        boolean gameWon = false;

        while (!gameWon) {

            user.setUserNumber();

            int strikes = countStrikes(computer.getComputerNumber(), user.getUserNumber());
            int balls = countBalls(computer.getComputerNumber(), user.getUserNumber());

            if (strikes == 3) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                gameWon = true;
            } else if (strikes > 0 || balls > 0) {
                System.out.println(balls + "볼 " + strikes + "스트라이크");
            } else {
                System.out.println("낫싱");
            }
        }
    }

    private int countStrikes(List<Integer> computerNumber, List<Integer> userNumber) {
        int strikes = 0;
        for (int i = 0; i < 3; i++) {
            if (computerNumber.get(i).equals(userNumber.get(i))) {
                strikes++;
            }
        }
        return strikes;
    }
    private int countBalls(List<Integer> computerNumber, List<Integer> userNumber) {
        int balls = 0;
        for (int i = 0; i < 3; i++) {
            if (computerNumber.contains(userNumber.get(i)) && !computerNumber.get(i).equals(userNumber.get(i))) {
                balls++;
            }
        }
        return balls;
    }

    private boolean replay() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int choice = Console.readLine().charAt(0) - '0';
        return (choice == 1);
    }
}
