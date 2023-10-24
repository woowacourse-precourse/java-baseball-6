package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import static org.mockito.Mockito.*;

public class Application {
    public static void main(String[] args) {
        while (true) {
            playGame();
            if (!wantsToRestartGame()) {
                System.out.println("게임을 종료합니다.");
                break;
            }
        }
    }

    private static void playGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        int[] computerNumbers = generateComputerNumbers();
        int[] userNumbers;
        int attempts = 0;

        while (true) {
            System.out.print("서로 다른 3자리의 수를 입력해주세요: ");
            String input = null;
            try {
                input = Console.readLine();
                if (input == null || input.length() != 3) {
                    throw new IllegalArgumentException("올바른 숫자를 입력해주세요.");
                }

                userNumbers = parseInput(input);
                if (userNumbers == null) {
                    throw new IllegalArgumentException("올바른 숫자를 입력해주세요.");
                }

                int[] result = calculateResult(computerNumbers, userNumbers);
                printResult(result);

                if (result[0] == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }

                attempts++;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("총 " + attempts + "회 시도하였습니다.");
    }


    private static int[] generateComputerNumbers() {
        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            numbers[i] = Randoms.pickNumberInRange(1, 9);
        }
        return numbers;
    }

    private static int[] parseInput(String input) {
        if (input.length() != 3) {
            return null;
        }

        int[] numbers = new int[3];
        try {
            for (int i = 0; i < 3; i++) {
                numbers[i] = Integer.parseInt(input.substring(i, i + 1));
            }
        } catch (NumberFormatException e) {
            return null;
        }

        return numbers;
    }

    private static int[] calculateResult(int[] computerNumbers, int[] userNumbers) {
        int[] result = new int[2]; // [볼, 스트라이크]

        for (int i = 0; i < 3; i++) {
            if (computerNumbers[i] == userNumbers[i]) {
                result[1]++; // 스트라이크
            } else if (containsNumber(computerNumbers, userNumbers[i])) {
                result[0]++; // 볼
            }
        }

        return result;
    }

    private static boolean containsNumber(int[] numbers, int target) {
        for (int number : numbers) {
            if (number == target) {
                return true;
            }
        }
        return false;
    }

    private static void printResult(int[] result) {
        if (result[0] == 0 && result[1] == 0) {
            System.out.println("낫싱");
        } else if (result[0] == 0) {
            System.out.println(result[1] + "스트라이크");
        } else if (result[1] == 0) {
            System.out.println(result[0] + "볼");
        } else {
            System.out.println(result[0] + "볼 " + result[1] + "스트라이크");
        }
    }

    private static boolean wantsToRestartGame() {
        while (true) {
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
            String input = Console.readLine();

            if (input == null || input.isEmpty()) {
                System.out.println("올바른 숫자를 입력해주세요.");
                continue;
            }

            if ("1".equals(input)) {
                return true;
            } else if ("2".equals(input)) {
                return false;
            } else {
                System.out.println("1 또는 2를 입력해주세요.");
            }
        }
    }

}
