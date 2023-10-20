package baseball;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean playAgain = true;

        while (playAgain) {
            List<Integer> computerNumbers = RandNum();

            boolean gameWon = false;
            int attempts = 0;

            while (!gameWon) {
                int[] userNumbers = getUserGuess();
                int[] result = checkGuess(userNumbers, computerNumbers);
                displayResult(result);

                if (result[0] == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    gameWon = true;
                }
                attempts++;
            }

            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
            int choice;
            try {
                choice = Integer.parseInt(Console.readLine());
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 게임을 종료합니다.");
                playAgain = false;
                continue;
            }

            if (choice == 2) {
                playAgain = false;
            }
        }
    }

    private static List<Integer> RandNum() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return computerNumbers;
    }

    private static int[] getUserGuess() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        int[] userNumbers = new int[3];
        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해야 합니다.");
        }
        for (int i = 0; i < 3; i++) {
            userNumbers[i] = Character.getNumericValue(input.charAt(i));
            if (userNumbers[i] < 1 || userNumbers[i] > 9) {
                throw new IllegalArgumentException("1에서 9 사이의 숫자를 입력해야 합니다.");
            }
        }
        return userNumbers;
    }

    private static int[] checkGuess(int[] userNumbers, List<Integer> computerNumbers) {
        int strikes = 0;
        int balls = 0;
        for (int i = 0; i < 3; i++) {
            if (userNumbers[i] == computerNumbers.get(i)) {
                strikes++;
            } else if (computerNumbers.contains(userNumbers[i])) {
                balls++;
            }
        }
        return new int[] { balls, strikes };
    }

    private static void displayResult(int[] result) {
        if (result[0] == 0 && result[1] == 0) {
            System.out.println("낫싱");
        } else {
            System.out.println(result[0] + "볼 " + result[1] + "스트라이크");
        }
    }
}
