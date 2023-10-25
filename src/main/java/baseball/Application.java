package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    static boolean correct = false;
    static List<Integer> computer;

    public static void main(String[] args) {
        while (true) {
            startGame();
            if (!continueGame()) {
                break;
            }
        }
    }

    private static void startGame() {
        generateRandomNumbers();
        System.out.println("숫자 야구 게임을 시작합니다.");

        correct = false;
        while (!correct) {
            String userInput = getUserInput();
            if (!isValidInput(userInput)) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
            checkNumbers(userInput);
        }
    }

    private static boolean continueGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = Console.readLine();
        return "1".equals(userInput);
    }

    private static boolean isValidInput(String input) {
        if (input.length() != 3) {
            return false;
        }
        for (char ch : input.toCharArray()) {
            if (ch < '1' || ch > '9') {
                return false;
            }
        }
        return true;
    }

    private static void generateRandomNumbers() {
        computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    private static String getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    private static void checkNumbers(String userInput) {
        int balls = 0;
        int strikes = 0;

        for (int i = 0; i < 3; i++) {
            int userNumber = Character.getNumericValue(userInput.charAt(i));
            if (userNumber == computer.get(i)) {
                strikes++;
            } else if (computer.contains(userNumber)) {
                balls++;
            }
        }

        if (strikes == 3) {
            correct = true;
            System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else {
            String result = getResultString(balls, strikes);
            System.out.println(result);
        }
    }

    private static String getResultString(int balls, int strikes) {
        if (balls == 0 && strikes == 0) {
            return "낫싱";
        }
        String result = "";
        if (balls > 0) {
            result += balls + "볼 ";
        }
        if (strikes > 0) {
            result += strikes + "스트라이크";
        }
        return result;
    }
}
