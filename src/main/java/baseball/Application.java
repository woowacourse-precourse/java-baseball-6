package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static void createRandomNumbers(List<Integer> computerNums) {
        while (computerNums.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNums.contains(randomNumber)) {
                computerNums.add(randomNumber);
            }
        }
    }

    private static void validateUserInputNumbers(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException("숫자 세 개를 입력해주세요.");
        } else if (userInput.charAt(0) == userInput.charAt(1)) {
            throw new IllegalArgumentException("중복되지 않은 숫자를 입력해주세요.");
        } else if (userInput.charAt(0) == userInput.charAt(2)) {
            throw new IllegalArgumentException("중복되지 않은 숫자를 입력해주세요.");
        } else if (userInput.charAt(1) == userInput.charAt(2)) {
            throw new IllegalArgumentException("중복되지 않은 숫자를 입력해주세요.");
        } else if (!Character.isDigit(userInput.charAt(0))) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        } else if (!Character.isDigit(userInput.charAt(1))) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        } else if (!Character.isDigit(userInput.charAt(2))) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    private static int compareNumbersPosition(Integer a, Integer b) {
        if (a == b) {
            return 1;
        }
        return 0;
    }

    private static int containsNumbers(Integer a, List<Integer> b) {
        if (b.contains(a)) {
            return 1;
        }
        return 0;
    }

    private static boolean printAndReturnResult(int strike, int ball) {
        if (ball > 0) {
            System.out.print(ball + "볼 ");
            if (strike < 1) {
                System.out.print("\n");
            }
        }
        if (strike > 0) {
            System.out.println(strike + "스트라이크");
        }
        if (ball + strike < 1) {
            System.out.println("낫싱");
        }
        if (strike == 3) {
            return false;
        }
        return true;
    }

    private static boolean validateRestartUserInput(String userInput) {
        if (userInput.length() != 1) {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
        } else if (!Character.isDigit(userInput.charAt(0))) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        } else if (userInput.equals("2")) {
            return false;
        }
        return true;
    }

    private static List<Integer> convertStringToIntegers(String str) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            arr.add(i, Character.getNumericValue(str.charAt(i)));
        }
        return arr;
    }

    private static boolean compareNumbersResult(List<Integer> userNums, List<Integer> computerNums) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < 3; i++) {
            strike += compareNumbersPosition(userNums.get(i), computerNums.get(i));
            ball += containsNumbers(userNums.get(i), computerNums);
        }
        return printAndReturnResult(strike, ball - strike);
    }

    private static List<Integer> inputUserNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();

        validateUserInputNumbers(userInput);

        List<Integer> userNumbers = convertStringToIntegers(userInput);

        return userNumbers;
    }

    private static boolean inputUserRestartStatus() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = Console.readLine();

        boolean isRestart = validateRestartUserInput(userInput);

        return isRestart;
    }

    public static void main(String[] args) {
        boolean isPlaying = true;
        List<Integer> computerNums = new ArrayList<>();
        List<Integer> userNums;

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (isPlaying) {
            createRandomNumbers(computerNums);

            userNums = inputUserNumbers();

            isPlaying = compareNumbersResult(userNums, computerNums);

            if (isPlaying == false) {
                computerNums.clear();

                isPlaying = inputUserRestartStatus();
            }
        }
    }
}
