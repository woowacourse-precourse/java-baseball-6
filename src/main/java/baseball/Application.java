package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            List<Integer> computer = generateRandomNumber();
            int attempts = 0;

            while (true) {
                int[] userGuess = getUserInput();
                int[] result = calculateResult(computer, userGuess);
                printResult(result);

                attempts++;

                if (result[0] == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int choice = Console.readLine().charAt(0) - '0';

            if (choice == 2) {
                break;
            }
        }
    }

    private static List<Integer> generateRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static int[] getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        if (!isValidInput(input)) {
            System.out.println("올바른 입력이 아닙니다. 3자리 서로 다른 숫자를 입력하세요.");
            return getUserInput();
        }

        int[] userGuess = new int[3];
        for (int i = 0; i < 3; i++) {
            userGuess[i] = input.charAt(i) - '0';
        }

        return userGuess;
    }

    private static boolean isValidInput(String input) {
        if (input.length() != 3) {
            return false;
        }
        if (!input.matches("[1-9]+")) {
            return false;
        }
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j < input.length(); j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[] calculateResult(List<Integer> computer, int[] userGuess) {
        int[] result = new int[2]; // result[0] = strikes, result[1] = balls

        for (int i = 0; i < 3; i++) {
            if (computer.get(i).equals(userGuess[i])) {
                result[0]++;
            } else if (computer.contains(userGuess[i])) {
                result[1]++;
            }
        }

        return result;
    }

    private static void printResult(int[] result) {
        if (result[0] == 0 && result[1] == 0) {
            System.out.println("낫싱");
        } else if (result[0] == 3) {
            return; // This case is handled in the main loop
        } else {
            System.out.println(result[1] + "볼 " + result[0] + "스트라이크");
        }
    }
}