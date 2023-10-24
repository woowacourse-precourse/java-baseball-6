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

    private static void validateUserInput(String userInput) {
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

    private static void printResult(int strike, int ball) {
        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike > 0) {
            System.out.println(strike + "스트라이크");
        }
        if (ball + strike < 1) {
            System.out.println("낫싱");
        }
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

    public static void main(String[] args) {
        int ball;
        int strike;
        String userInput;

        List<Integer> computerNums = new ArrayList<>();

        boolean userPlay = true;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (userPlay) {
            createRandomNumbers(computerNums);
            System.out.print("숫자를 입력해주세요 : ");
            userInput = Console.readLine();

            validateUserInput(userInput);

            List<Integer> userNums = new ArrayList<>();
            for (int i = 0; i < userInput.length(); i++) {
                userNums.add(i, Character.getNumericValue(userInput.charAt(i)));
            }

            strike = 0;
            ball = 0;
            for (int i = 0; i < 3; i++) {
                strike += compareNumbersPosition(userNums.get(i), computerNums.get(i));
                ball += containsNumbers(userNums.get(i), computerNums);
            }

            printResult(strike, ball - strike);
            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                computerNums.clear();
                userInput = Console.readLine();
                userPlay = validateRestartUserInput(userInput);
            }
        }
    }
}
