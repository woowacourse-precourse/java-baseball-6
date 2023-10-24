package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            List<Integer> computer = generateComputerNumber();
            int tries = 0;

            while (true) {
                String userGuess = getUserInput();
                List<Integer> userNumbers = parseUserInput(userGuess);

                if (!isValidInput(userNumbers)) {
                    System.out.println("유효하지 않은 입력입니다. 1부터 9까지 서로 다른 3자리 숫자를 입력하세요.");
                    continue;
                }

                int[] result = calculateResult(computer, userNumbers);
                displayResult(result);

                if (result[0] == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }

                tries++;
            }

            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
            if (getUserInput().equals("2")) {
                break;
            }
        }
    }

    private static List<Integer> generateComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private static String getUserInput() {
        String userInput = "";
        boolean validInput = false;
        while (!validInput) {
            System.out.print("숫자를 입력해주세요: ");
            userInput = Console.readLine();
            try {
                validateUserInput(userInput);
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return userInput;
    }

    private static void validateUserInput(String userInput) {
    }

    private static List<Integer> parseUserInput(String input) {
        List<Integer> userNumbers = new ArrayList<>();
        for (char digit : input.toCharArray()) {
            userNumbers.add(Character.getNumericValue(digit));
        }
        return userNumbers;
    }

    private static boolean isValidInput(List<Integer> userNumbers) {
        return userNumbers.size() == 3
                && userNumbers.stream().distinct().count() == 3
                && userNumbers.stream().allMatch(num -> num >= 1 && num <= 9);
    }

    private static int[] calculateResult(List<Integer> computer, List<Integer> userNumbers) {
        int[] result = new int[2];

        for (int i = 0; i < 3; i++) {
            if (computer.get(i).equals(userNumbers.get(i))) {
                result[0]++; // 스트라이크
            } else if (computer.contains(userNumbers.get(i))) {
                result[1]++; // 볼
            }
        }

        return result;
    }

    private static void displayResult(int[] result) {
        if (result[0] == 0 && result[1] == 0) {
            System.out.println("낫싱");
        } else if (result[0] > 0 && result[1] > 0) {
            System.out.println(result[0] + "볼 " + result[1] + "스트라이크");
        } else if (result[0] > 0) {
            System.out.println(result[0] + "스트라이크");
        } else if (result[1] > 0) {
            System.out.println(result[1] + "볼");
        }
    }
}


