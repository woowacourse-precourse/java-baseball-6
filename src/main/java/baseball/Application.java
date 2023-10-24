package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            playGame();
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
            int choice = Integer.parseInt(Console.readLine());
            if (choice == 2) {
                System.out.println("게임을 종료합니다.");
                break;
            }
        }

    }

    private static void playGame() {
        int[] computerNumbers = generateComputerNumbers();
        while (true) {
            int[] userNumbers = getUserInput();
            String result = calculateResult(computerNumbers, userNumbers);
            System.out.println(result);
            if (result.equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    private static int[] generateComputerNumbers() {
        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            int num = Randoms.pickNumberInRange(1, 9);
            while (contains(numbers, num)) {
                num = Randoms.pickNumberInRange(1, 9);
            }
            numbers[i] = num;
        }
        return numbers;
    }

    private static int[] getUserInput() {
        int[] numbers = new int[3];
        while (true) {
            System.out.print("서로 다른 3자리의 수를 입력하세요: ");
            String input = Console.readLine();
            if (input.length() != 3) {
                System.out.println("잘못된 입력입니다. 3자리의 수를 입력해주세요.");
                continue;
            }
            try {
                for (int i = 0; i < 3; i++) {
                    numbers[i] = Integer.parseInt(input.substring(i, i + 1));
                }
                if (areDistinct(numbers)) {
                    break;
                } else {
                    System.out.println("서로 다른 숫자를 입력해주세요.");
                }
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
            }
        }
        return numbers;
    }

    private static boolean contains(int[] arr, int num) {
        for (int value : arr) {
            if (value == num) {
                return true;
            }
        }
        return false;
    }

    private static boolean areDistinct(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static String calculateResult(int[] computerNumbers, int[] userNumbers) {
        int strikes = 0;
        int balls = 0;
        for (int i = 0; i < 3; i++) {
            if (computerNumbers[i] == userNumbers[i]) {
                strikes++;
            } else if (contains(computerNumbers, userNumbers[i])) {
                balls++;
            }
        }

        if (strikes == 0 && balls == 0) {
            return "낫싱";
        }

        StringBuilder result = new StringBuilder();
        if (strikes > 0) {
            result.append(strikes).append("스트라이크");
        }
        if (balls > 0) {
            if (strikes > 0) {
                result.append(" ");
            }
            result.append(balls).append("볼");
        }

        return result.toString();
    }
}
}
