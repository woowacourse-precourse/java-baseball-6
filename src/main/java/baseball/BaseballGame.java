package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.LinkedHashSet;
import java.util.Set;

public class BaseballGame {
    public void startGame() {
        boolean playAgain = true;

        while (playAgain) {
            playGame();
            playAgain = askToPlayAgain();
        }

        System.out.println("게임 종료");
    }

    private void playGame() {
        int[] computerNumbers = generateComputerNumbers();
        int attempts = 0;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            int[] userNumbers = getUserNumbers();
            int[] result = calculateResult(computerNumbers, userNumbers);

            printResult(result);

            if (result[0] == 3) {
                System.out.println("승리! " + (attempts + 1) + "번 만에 정답을 맞췄습니다.");
                break;
            }

            attempts++;
        }
    }

    private int[] generateComputerNumbers() {
        Set<Integer> numbers = new LinkedHashSet<>();

        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            numbers.add(randomNumber);
        }

        int[] result = new int[3];
        int i = 0;
        for (int number : numbers) {
            result[i] = number;
            i++;
        }

        return result;
    }

    private int[] getUserNumbers() {
        int[] userNumbers = new int[3];

        while (true) {
            try {
                String userInput = readUserInput();
                userNumbers = parseUserInput(userInput);
                return userNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.exit(0);
            }
        }
    }

    private String readUserInput() {
        System.out.print("세 자리 숫자를 입력하세요: ");
        return Console.readLine();
    }

    private int[] parseUserInput(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("세 자리 숫자를 입력하세요.");
        }

        int[] userNumbers = new int[3];
        for (int i = 0; i < 3; i++) {
            userNumbers[i] = userInput.charAt(i) - '0';
            if (userNumbers[i] < 1 || userNumbers[i] > 9) {
                throw new IllegalArgumentException("1에서 9 사이의 숫자를 입력하세요.");
            }
        }

        return userNumbers;
    }

    private int[] calculateResult(int[] computerNumbers, int[] userNumbers) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            if (computerNumbers[i] == userNumbers[i]) {
                strikes++;
            } else if (containsNumber(computerNumbers[i], userNumbers)) {
                balls++;
            }
        }

        return new int[]{strikes, balls};
    }

    private boolean containsNumber(int number, int[] numbers) {
        for (int num : numbers) {
            if (num == number) {
                return true;
            }
        }
        return false;
    }

    private static void printResult(int[] result) {
        if (result[1] > 0) {
            System.out.print(result[1] + "볼 ");
        }
        if (result[0] > 0) {
            System.out.print(result[0] + "스트라이크 ");
        }
        if (result[0] == 0 && result[1] == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

    private static boolean askToPlayAgain() {
        System.out.print("게임을 다시 하시겠습니까? (1:새로 시작, 2:종료): ");
        String input = Console.readLine().trim();
        if (input.equals("1")) {
            return true;
        } else if (input.equals("2")) {
            return false;
        } else {
            System.out.println("1 또는 2 중 하나를 입력하세요.");
            return askToPlayAgain();
        }
    }
}
