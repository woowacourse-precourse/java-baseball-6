package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        playNumberBaseballGame();
    }

    public static void playNumberBaseballGame() {
        boolean isGameOver = false;

        do {
            int[] computerNumbers = generateComputerNumbers();
            int[] userNumbers;
            boolean canRestartOrExit = false;

            while (true) {
                System.out.println("숫자 야구 게임을 시작합니다.");
                System.out.print("숫자를 입력해주세요 : ");
                String userInput = Console.readLine();

                if (userInput.equals("2") && canRestartOrExit) {
                    System.out.println("게임을 종료합니다.");
                    isGameOver = true;
                    break;
                } else if (userInput.equals("1") && canRestartOrExit) {
                    System.out.println("게임을 재시작합니다.");
                    break;
                }

                userNumbers = parseUserInput(userInput);
                canRestartOrExit = true;

                int[] result = checkGuess(computerNumbers, userNumbers);
                printGuessResult(result);

                if (result[0] == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    canRestartOrExit = true;

                    System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
                    userInput = Console.readLine();

                    if (userInput.equals("2")) {
                        System.out.println("프로그램을 종료합니다.");
                        return; // 프로그램 종료
                    } else if (userInput.equals("1")) {
                        break; // 게임 재시작
                    }
                }
            }
        } while (!isGameOver);
    }

    public static int[] generateComputerNumbers() {
        int[] numbers = new int[3];

        do {
            numbers[0] = Randoms.pickNumberInRange(1, 9);
            numbers[1] = Randoms.pickNumberInRange(1, 9);
            numbers[2] = Randoms.pickNumberInRange(1, 9);
        } while (containsDuplicateNumbers(numbers));

        return numbers;
    }

    public static int[] parseUserInput(String userInput) throws IllegalArgumentException {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("1에서 9까지 서로 다른 3자리 숫자를 입력하세요.");
        }

        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            char digit = userInput.charAt(i);
            if (digit < '1' || digit > '9') {
                throw new IllegalArgumentException("1에서 9까지의 숫자만 입력하세요.");
            }
            numbers[i] = digit - '0';
        }

        if (containsDuplicateNumbers(numbers)) {
            throw new IllegalArgumentException("서로 다른 숫자를 입력하세요.");
        }

        return numbers;
    }

    public static int[] checkGuess(int[] computerNumbers, int[] userNumbers) {
        int[] result = new int[3];

        for (int i = 0; i < 3; i++) {
            if (userNumbers[i] == computerNumbers[i]) {
                result[0]++;
            } else if (contains(computerNumbers, userNumbers[i])) {
                result[1]++;
            } else {
                result[2]++;
            }
        }

        return result;
    }

    public static boolean contains(int[] array, int target) {
        for (int number : array) {
            if (number == target) {
                return true;
            }
        }
        return false;
    }

    public static void printGuessResult(int[] result) {
        String message = "";

        if (result[1] > 0) {
            message += result[1] + "볼 ";
        }

        if (result[0] > 0) {
            message += result[0] + "스트라이크 ";
        }

        if (message.isEmpty()) {
            message = "낫싱";
        }

        System.out.println(message);
    }

    public static boolean containsDuplicateNumbers(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
