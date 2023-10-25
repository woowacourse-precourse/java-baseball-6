package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        playGame();
    }

    public static void playGame() {
        int[] computerNumbers = generateComputerNumbers();
        int attempts = 0;

        while (attempts < 10) {
            int[] userGuess = getUserGuess();
            int[] result = calculateResult(computerNumbers, userGuess);
            printResult(result);

            if (result[1] == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }

            attempts++;
            System.out.println("남은 시도 횟수: " + (10 - attempts));
        }

        System.out.println("게임을 다시 시작하려면 1, 종료하려면 2를 입력하세요.");
        int choice = Integer.parseInt(Console.readLine());

        if (choice == 1) {
            playGame();
        } else {
            System.out.println("게임을 종료합니다.");
            Console.close();
        }
    }

    public static int[] generateComputerNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int num = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(num)) {
                numbers.add(num);
            }
        }

        int[] computerNumbers = new int[3];
        for (int i = 0; i < 3; i++) {
            computerNumbers[i] = numbers.get(i);
        }

        return computerNumbers;
    }

    public static int[] getUserGuess() {
        System.out.print("숫자를 입력해주세요 : ");
        int[] userGuess = new int[3];

        String userInput = Console.readLine();
        if (!userInput.matches("^[0-9]{3}$")) {
            throw new IllegalArgumentException("세 자리 숫자를 입력하세요.");
        }

        for (int i = 0; i < 3; i++) {
            userGuess[i] = Character.getNumericValue(userInput.charAt(i));
        }

        return userGuess;
    }



    public static int[] calculateResult(int[] computerNumbers, int[] userGuess) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            if (computerNumbers[i] == userGuess[i]) {
                strikes++;
            } else if (contains(computerNumbers, userGuess[i])) {
                balls++;
            }
        }

        return new int[]{balls, strikes};
    }

    public static boolean contains(int[] numbers, int target) {
        for (int number : numbers) {
            if (number == target) {
                return true;
            }
        }
        return false;
    }

    public static void printResult(int[] result) {
        if (result[0] > 0 && result[1] > 0) {
            System.out.println(result[0] + "볼 " + result[1] + "스트라이크");
        } else if (result[0] > 0) {
            System.out.println(result[0] + "볼");
        } else if (result[1] > 0) {
            System.out.println(result[1] + "스트라이크");
        } else {
            System.out.println("낫싱");
        }
    }
}
