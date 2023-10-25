package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean isGameRunning = true;
        while (isGameRunning) {
            List<Integer> computer = generateRandomNumber();
            int attempts = 0;

            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String userInput = Console.readLine();
                if (!isValidInput(userInput)) {
                    System.out.println("올바른 입력이 아닙니다. 1에서 9까지 서로 다른 3자리 수를 입력하세요.");
                    throw new IllegalArgumentException("잘못된 입력입니다.");
                }

                List<Integer> userGuess = parseUserInput(userInput);
                Result result = calculateResult(computer, userGuess);
                displayResult(result);

                if (result.getStrikes() == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }

                attempts++;
            }

            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
            String choice = Console.readLine();
            if ("2".equals(choice)) {
                isGameRunning = false;
            }
        }
    }

    private static List<Integer> generateRandomNumber() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    private static boolean isValidInput(String input) {
        return input.matches("^[1-9]{3}$") && isDistinct(input);
    }

    private static boolean isDistinct(String input) {
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j < input.length(); j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static List<Integer> parseUserInput(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (char c : input.toCharArray()) {
            numbers.add(Character.getNumericValue(c));
        }
        return numbers;
    }

    private static Result calculateResult(List<Integer> computer, List<Integer> userGuess) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i).equals(userGuess.get(i))) {
                strikes++;
            } else if (computer.contains(userGuess.get(i))) {
                balls++;
            }
        }

        return new Result(strikes, balls);
    }

    private static void displayResult(Result result) {
        if (result.getStrikes() == 0 && result.getBalls() == 0) {
            System.out.println("낫싱");
        } else if (result.getStrikes() == 0) {
            System.out.println(result.getBalls() + "볼");
        } else if (result.getBalls() == 0) {
            System.out.println(result.getStrikes() + "스트라이크");
        } else {
            System.out.println(result.getBalls() + "볼 " + result.getStrikes() + "스트라이크");
        }
    }
}
