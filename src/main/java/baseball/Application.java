package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {s
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            List<Integer> computerNumbers = generateComputerNumbers();
            int tries = 0;

            while (true) {
                List<Integer> userNumbers = getUserInput();

                int[] result = calculateResult(computerNumbers, userNumbers);
                displayResult(result);

                if (result[0] == 0 && result[1] == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }

                tries++;
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int choice = Console.readLine().charAt(0) - '0';
            if (choice == 2) {
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

        if (input.length() != 3 || !input.matches("[1-9]{3}")) {
            throw new IllegalArgumentException("올바른 형식의 숫자를 입력하세요.");
        }

        List<Integer> userNumbers = new ArrayList<>();
        for (char digit : input.toCharArray()) {
            userNumbers.add(digit - '0');
        }

        return userNumbers;
    }

    private static int[] calculateResult(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            if (computerNumbers.get(i).equals(userNumbers.get(i))) {
                strikes++;
            } else if (computerNumbers.contains(userNumbers.get(i))) {
                balls++;
            }
        }

        return new int[]{balls, strikes};
    }

    private static void displayResult(int[] result) {
        if (result[0] == 0 && result[1] == 0) {
            System.out.println("낫싱");
        } else {
            System.out.println(result[0] + "볼 " + result[1] + "스트라이크");
        }
    }
}
