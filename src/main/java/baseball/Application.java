package baseball;

import baseball.number.ComputerNumber;
import baseball.number.Number;
import baseball.number.UserNumber;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        runGame();
    }

    private static void runGame() {
        boolean restart = true;
        while (restart) {
            restart = baseballGame();
        }
    }

    private static boolean baseballGame() {
        Number computerNumbers = new ComputerNumber();

        boolean answer = false;
        while (!answer) {
            Number userNumbers = new UserNumber();
            answer = matchNumbers(computerNumbers.getNumbers(), userNumbers.getNumbers());
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        int restart = 0;
        try {
            restart = Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("1과 2만 입력해주세요.");
        }

        if ((restart != 1) && (restart != 2)) {
            throw new IllegalArgumentException("1과 2만 입력해주세요.");
        }

        return (restart == 1) ? true : false;
    }

    private static boolean matchNumbers(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            int computerNumber = computerNumbers.get(i);
            int userNumber = userNumbers.get(i);

            if (computerNumber == userNumber) {
                strike++;
            }

            if ((computerNumber != userNumber) && (userNumbers.contains(computerNumber))) {
                ball++;
            }
        }

        if (ball == 0 && strike == 0) {
            System.out.print("낫싱");
        }

        if (ball != 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike != 0) {
            System.out.print(strike + "스트라이크");
        }
        System.out.println();

        return (strike == 3) ? true : false;
    }
}
