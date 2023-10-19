package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        getStart();

        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
            String coin = Console.readLine();
            if ("2".equals(coin)) {
                System.out.println("게임을 종료합니다.");
                break;
            } else if ("1".equals(coin)) {
                System.out.println("게임을 새로 시작합니다.");
                getStart();
            } else {
                System.out.println("잘못된 입력입니다. 1 또는 2를 입력하세요.");
            }
        }
    }

    private static void getStart() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumberForComputer = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumberForComputer)) {
                computer.add(randomNumberForComputer);
            }
        }

        while (true) {
            System.out.print("숫자를 입력해주세요(현재 게임을 종료하고싶다면 'q'를 입력하세요.) : ");
            String user = Console.readLine();
            String quit = "q";
            if (user.equalsIgnoreCase(quit)) {
                System.out.println("현재 게임을 종료합니다.");
                break;
            }
            validUserInput(user);

            int[] result = playBall(computer, user);
            if (result[0] == 3) {
                System.out.println(result[0] + "스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
            printResult(result);
        }
    }

    private static void printResult(final int[] result) {
        int strike = result[0];
        int ball = result[1];

        if (strike != 0 && ball != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }

        if (strike != 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
        }

        if (strike == 0 && ball != 0) {
            System.out.println(ball + "볼");
        }
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
    }

    private static int[] playBall(List<Integer> computer, String user) {
        int[] count = new int[2];

        for (int i = 0; i < user.length(); i++) {
            int userData = Character.getNumericValue(user.charAt(i));
            if (computer.get(i) == userData) {
                count[0]++;
            }
            if (computer.get(i) != userData && computer.contains(userData)) {
                count[1]++;
            }
        }
        return count;
    }

    private static void validUserInput(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("세자리 수를 입력해주세요.");
        }
        if (!userInput.matches("[1-9]+$")) {
            throw new IllegalArgumentException("1부터 9사이의 숫자를 입력하세요.");
        }
        HashSet<Character> unique = new HashSet<>();
        for (char x : userInput.toCharArray()) {
            if (unique.contains(x)) {
                throw new IllegalArgumentException("중복된 수가 입력되었습니다.");
            }
            unique.add(x);
        }
    }
}
