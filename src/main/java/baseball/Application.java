package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        while (true) {
            List<Integer> computer = generateRandomNumber();
            playGame(computer);
            if (!continueGame()) {
                break;
            }
        }
    }

    private static List<Integer> generateRandomNumber() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    private static void playGame(List<Integer> computer) {
        System.out.println("숫자야구 게임을 시작합니다!");
        List<Integer> user = new ArrayList<>();

        while (true) {
            user = getUserInput();
            int strike = countStrike(computer, user);
            int ball = countBall(computer, user);

            printResult(strike, ball);

            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    private static List<Integer> getUserInput() {
        List<Integer> user = new ArrayList<>();

        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        user.add(Integer.parseInt(input.substring(0, 1)));
        user.add(Integer.parseInt(input.substring(1, 2)));
        user.add(Integer.parseInt(input.substring(2, 3)));

        return user;
    }

    private static int countStrike(List<Integer> computer, List<Integer> user) {
        int strike = 0;

        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i).equals(user.get(i))) {
                strike++;
            }
        }

        return strike;
    }

    private static int countBall(List<Integer> computer, List<Integer> user) {
        int ball = 0;

        for (int i = 0; i < computer.size(); i++) {
            if (computer.contains(user.get(i)) && !computer.get(i).equals(user.get(i))) {
                ball++;
            }
        }

        return ball;
    }

    private static void printResult(int strike, int ball) {
        if (strike > 0) {
            System.out.println(strike + "스트라이크");
        }
        if (ball > 0) {
            System.out.println(ball + "볼");
        }
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }

    }

    private static boolean continueGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        return "1".equals(input);
    }
}
