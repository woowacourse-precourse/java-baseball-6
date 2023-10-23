package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            List<Integer> computer = generateComputerNumbers();
            while (true) {
                List<Integer> userGuess = getUserInput();
                String result = calculateResult(computer, userGuess);
                System.out.println(result);

                if ("3스트라이크".equals(result)) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }
            
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int choice = Console.readLine().charAt(0) - '0';
            if (choice == 2) {
                System.out.println("게임을 종료합니다.");
                break;
            }
        }
    }

    private static List<Integer> generateComputerNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static List<Integer> getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
        List<Integer> userGuess = new ArrayList<>();

        for (char digit : input.toCharArray()) {
            int num = digit - '0';
            if (num < 1 || num > 9) {
                throw new IllegalArgumentException();
            }
            userGuess.add(num);
        }
        return userGuess;
    }

    private static String calculateResult(List<Integer> computer, List<Integer> userGuess) {
        int strikes = 0;
        int balls = 0;
        for (int i = 0; i < 3; i++) {
            if (computer.get(i).equals(userGuess.get(i))) {
                strikes++;
            } else if (computer.contains(userGuess.get(i))) {
                balls++;
            }
        }

        if (strikes > 0 && balls > 0) {
            return strikes + "스트라이크 " + balls + "볼";
        } else if (strikes > 0) {
            return strikes + "스트라이크";
        } else if (balls > 0) {
            return balls + "볼";
        } else {
            return "낫싱";
        }
    }
}