package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {

    public static void main(String[] args) {
        do {
            startGame();
        } while (!isExitGame());
    }


    public static void startGame() {
        boolean isDone = false;
        List<Integer> computer = setComputerNumber();

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (!isDone) {
            List<Integer> inputNumbers = getUserNumber();
            isDone = isThreeStrike(computer, inputNumbers);
        }
    }

    public static List<Integer> setComputerNumber() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }

        return randomNumbers;
    }

    public static List<Integer> getUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        List<Integer> inputNumbers = new ArrayList<>();

        if (!isValidNumber(input)) {
            throw new IllegalArgumentException("올바르지 않은 입력입니다.");
        }

        for (String s : input.split("")) {
            inputNumbers.add(Integer.parseInt(s));
        }

        return inputNumbers;
    }

    public static boolean isValidNumber(final String input) {
        if (input.length() != 3) {
            return false;
        }

        if (input.contains("0")) {
            return false;
        }

        for (char ch : input.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }

        // 중복되는 숫자가 있으면 false를 반환한다.
        Set<Character> uniqueNumbers = new HashSet<>();
        for (char ch : input.toCharArray()) {
            if (!uniqueNumbers.add(ch)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isThreeStrike(final List<Integer> randomNumbers, final List<Integer> inputNumbers) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < randomNumbers.size(); i++) {
            if (randomNumbers.get(i).equals(inputNumbers.get(i))) {
                strikeCount++;
            }
        }

        for (int i = 0; i < randomNumbers.size(); i++) {
            if (!randomNumbers.get(i).equals(inputNumbers.get(i)) && randomNumbers.contains(inputNumbers.get(i))) {
                ballCount++;
            }
        }

        printResult(strikeCount, ballCount);

        if (strikeCount == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }

        return false;
    }

    private static void printResult(final int strikeCount, final int ballCount) {
        if (strikeCount > 0 && ballCount > 0) {
            System.out.printf("%d볼 %d스트라이크", ballCount, strikeCount);
        } else if (strikeCount == 0 && ballCount > 0) {
            System.out.printf("%d볼", ballCount);
        } else if (strikeCount > 0 && ballCount == 0) {
            System.out.printf("%d스트라이크", strikeCount);
        } else {
            System.out.print("낫싱");
        }
        System.out.println();
    }

    public static boolean isExitGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = Console.readLine();

        if (userInput.equals("1")) {
            return false;
        } else if (userInput.equals("2")) {
            return true;
        } else {
            throw new IllegalArgumentException("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
        }
    }
}