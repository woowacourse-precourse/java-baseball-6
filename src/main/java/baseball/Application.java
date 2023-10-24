package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            List<Integer> computer = generateRandomNumber();
            boolean gameWon = false;

            while (!gameWon) {
                List<Integer> userGuess = getUserGuess();
                int[] result = compareNumbers(computer, userGuess);
                displayResult(result);

                if (result[0] == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String choice = Console.readLine();
            if (!choice.equals("1") && !choice.equals("2")){
                throw new IllegalArgumentException("잘못된 입력입니다.");
            } else if (choice.equals("2")) {
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

    private static List<Integer> getUserGuess() {
        while (true) {
            System.out.print("숫자를 입력해주세요: ");
            String input = Console.readLine();

            if (isValidInput(input)) {
                List<Integer> userGuess = new ArrayList<>();
                for (char c : input.toCharArray()) {
                    userGuess.add(Character.getNumericValue(c));
                }
                return userGuess;
            } else {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }
    }

    private static boolean isValidInput(String input) {
        return input.matches("[1-9]{3}") && input.chars().distinct().count() == 3;
    }

    private static int[] compareNumbers(List<Integer> computer, List<Integer> userGuess) {
        int[] result = new int[2]; // result[0] - strikes, result[1] - balls

        for (int i = 0; i < 3; i++) {
            if (computer.get(i).equals(userGuess.get(i))) {
                result[0]++;
            } else if (computer.contains(userGuess.get(i))) {
                result[1]++;
            }
        }

        return result;
    }

    private static void displayResult(int[] result) {
        if (result[1] > 0) {
            System.out.print(result[1] + "볼 ");
        }
        if (result[0] > 0) {
            System.out.print(result[0] + "스트라이크");
        }
        if (result[0] == 0 && result[1] == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }
}
