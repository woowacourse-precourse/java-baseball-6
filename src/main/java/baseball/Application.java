package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Application {


    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            List<Integer> computerNumbers = generateComputerNumbers();
            int attempts = 0;

            while (true) {
                try {
                    String userGuess = getUserInput();
                    List<Integer> userNumbers = parseUserInput(userGuess);
                    String result = calculateResult(computerNumbers, userNumbers);
                    System.out.println(result);

                    if (result.equals("3스트라이크")) {
                        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                        break;
                    }

                    attempts++;
                } catch (IllegalArgumentException e) {
                    // 추가: 게임 종료
                    System.out.println("잘못된 입력 값입니다. 게임을 종료합니다.");
                    return;
                }
            }

            int choice = askForNewGame();
            if (choice == 2) {
                System.out.println("잘못된 입력 값입니다. 게임을 종료합니다.");
                return; // 종료
            }
        }
    }

    private static List<Integer> generateComputerNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static String getUserInput() {
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = readLine();
            if (isValidUserInput(input)) {
                return input;
            } else {
                throw new IllegalArgumentException("잘못된 입력 값입니다. 게임을 종료합니다.");
            }
        }
    }

    private static boolean isValidUserInput(String input) {
        if (input.length() != 3) {
            return false;
        }

        List<Character> seenDigits = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            char c = input.charAt(i);
            if (c < '1' || c > '9' || seenDigits.contains(c)) {
                return false;
            }
            seenDigits.add(c);
        }

        return true;
    }

    private static List<Integer> parseUserInput(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int digit = Character.getNumericValue(c);
            numbers.add(digit);
        }
        return numbers;
    }

    private static String calculateResult(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            int computerDigit = computerNumbers.get(i);
            int userDigit = userNumbers.get(i);

            if (computerDigit == userDigit) {
                strikes++;
            } else if (userNumbers.contains(computerDigit)) {
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

    private static int askForNewGame() {
        while (true) {
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
            String choice = readLine();
            if (choice.equals("1") || choice.equals("2")) {
                return Integer.parseInt(choice);
            } else {
                System.out.println("올바른 선택이 아닙니다. 1 또는 2 중 하나를 입력하세요.");
            }
        }
    }

    private static int pickNumberInRange(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    private static String readLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();

        // TODO: 프로그램 구현
    }
}
