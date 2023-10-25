package baseball;

import java.util.*;

public class Application {

    private static final int NUMBER_LENGTH = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueGame = true;

        while (continueGame) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            String computerNumber = generateComputerNumber();

            boolean gameWon = false;
            while (!gameWon) {
                System.out.print("숫자를 입력해주세요 : ");
                String userNumber = scanner.next();

                try {
                    validateInput(userNumber);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    return;
                }

                String result = checkNumber(computerNumber, userNumber);
                System.out.println(result);

                if (result.startsWith("3스트라이크")) {
                    gameWon = true;
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int continueChoice = scanner.nextInt();
            continueGame = (continueChoice == 1);
        }

        scanner.close();
    }

    private static String generateComputerNumber() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Collections.shuffle(numbers);
        return numbers.subList(0, NUMBER_LENGTH).stream()
            .map(String::valueOf)
            .reduce("", (acc, number) -> acc + number);
    }

    private static void validateInput(String input) {
        if (input.length() != NUMBER_LENGTH || !input.matches("[1-9]+")) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
    }

    private static String checkNumber(String computerNumber, String userNumber) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < NUMBER_LENGTH; i++) {
            char userChar = userNumber.charAt(i);
            if (computerNumber.charAt(i) == userChar) {
                strikes++;
            } else if (computerNumber.contains(String.valueOf(userChar))) {
                balls++;
            }
        }

        if (strikes == 0 && balls == 0) {
            return "낫싱";
        } else if (strikes == NUMBER_LENGTH) {
            return "3스트라이크";
        } else {
            return balls + "볼 " + strikes + "스트라이크";
        }
    }
}
