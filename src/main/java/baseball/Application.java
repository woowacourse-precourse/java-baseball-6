package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedList;
import java.util.List;

public class Application {
    private static final String RESTART_OPTION = "1";
    private static final String EXIT_OPTION = "2";

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean restart = true;
        while (restart) {
            gameStart();
            restart = askToRestart();
        }
    }

    private static void gameStart() {
        String computer = generateRandomNumber();
        boolean gameOver = false;
        while (!gameOver) {
            String player = getUserInput();
            int strike = countStrikes(computer, player);
            int ball = countBalls(computer, player);
            gameOver = checkGameStatus(strike, ball);
        }
    }

    private static String generateRandomNumber() {
        String computer = "";
        while (computer.length() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(Integer.toString(randomNumber))) computer += randomNumber;
        }
        return computer;
    }

    private static String getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String player = Console.readLine();
        validatePlayerInput(player);
        return player;
    }

    private static void validatePlayerInput(String player) {
        List<Integer> list = new LinkedList<>();
        if (player.length() != 3) throw new IllegalArgumentException();
        for (int i = 0; i < 3; i++) {
            int number = player.charAt(i) - '0';
            if (number < 1 || number > 9) throw new IllegalArgumentException();
            if (list.contains(number)) throw new IllegalArgumentException();
            else list.add(number);
        }
    }

    private static int countStrikes(String computer, String player) {
        int strike = 0;
        for (int i = 0; i < 3; i++)
            if (player.charAt(i) == computer.charAt(i))
                strike++;
        return strike;
    }

    private static int countBalls(String computer, String player) {
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (player.charAt(i) != computer.charAt(i) && computer.contains(Character.toString(player.charAt(i))))
                ball++;
        }
        return ball;
    }

    private static boolean checkGameStatus(int strike, int ball) {
        if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else {
            displayResult(ball, strike);
            return false;
        }
    }

    private static void displayResult(int ball, int strike) {
        if (ball > 0) System.out.print(ball + "볼 ");
        if (strike > 0) System.out.print(strike + "스트라이크");
        if (ball == 0 && strike == 0) System.out.print("낫싱");
        System.out.println();
    }

    private static boolean askToRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (input.equals(RESTART_OPTION)) return true;
        else if (input.equals(EXIT_OPTION)) return false;
        else throw new IllegalArgumentException();
    }
}
