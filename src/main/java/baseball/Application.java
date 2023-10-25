package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean keepGoing = true;
        while (keepGoing) {
            keepGoing = startGame();
        }
    }

    public static boolean startGame() {
        List<Integer> computerNumbers = generateRandomNumbers();
        boolean isCorrect = false;
        while (!isCorrect) {
            isCorrect = checkNumbers(computerNumbers, getUserNumbers());
        }
        return askRestart();
    }

    public static List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randNum = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randNum)) {
                numbers.add(randNum);
            }
        }
        return numbers;
    }

    public static List<Integer> getUserNumbers() {
        System.out.println("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        validateInput(input);
        List<Integer> userNumbers = new ArrayList<>();
        for (char c : input.toCharArray()) {
            userNumbers.add(Character.getNumericValue(c));
        }
        return userNumbers;
    }

    public static void validateInput(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리의 숫자를 입력해주세요.");
        }
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("숫자만 입력해주세요.");
            }
            if (c == '0') {
                throw new IllegalArgumentException("0은 입력할 수 없습니다.");
            }
            if (input.indexOf(c) != input.lastIndexOf(c)) {
                throw new IllegalArgumentException("중복된 숫자를 입력할 수 없습니다.");
            }
        }
    }

    public static boolean checkNumbers(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (computerNumbers.get(i).equals(userNumbers.get(i))) {
                strike++;
            } else if (computerNumbers.contains(userNumbers.get(i))) {
                ball++;
            }
        }
        return printResult(strike, ball);
    }

    public static boolean printResult(int strike, int ball) {
        if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return false;
        }
        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike > 0) {
            System.out.print(strike + "스트라이크");
        }
        System.out.println();
        return false;
    }

    public static boolean askRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
        }
        return input.equals("1");
    }
}
