package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private final static int MIN_RANGE = 1;
    private final static int MAX_RANGE = 9;
    private final static int NUM_DIGITS = 3;
    private final static int RESTART = 1;
    private final static int EXIT = 2;
    private boolean isRestart = true;
    public BaseballGame() {
    }
    public void run() {
        while (isRestart) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            try {
                playGame();
            } catch (IllegalArgumentException e) {
                isRestart = false;
                throw e;
            }
            isRestart = choiceRestart();
        }
    }
    private void playGame() {
        List<Integer> numberList = createRandomNumber();
        boolean isWin = false;
        do {
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = Console.readLine();
            try {
                validateNumber(userInput);
                int result = compareNumber(numberList, userInput);
                System.out.println(printResult(result));
                if (result == NUM_DIGITS) {
                    isWin = true;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("ERROR: " + e.getMessage());
                throw e;
            }
        } while (!isWin);
    }

    private List<Integer> createRandomNumber() {
        List<Integer> numberList = new ArrayList<>();
        while (numberList.size() < NUM_DIGITS) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
            if (!numberList.contains(randomNumber)) {
                numberList.add(randomNumber);
            }
        }
        return numberList;
    }
    private int compareNumber(List<Integer> numberList, String userInput) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < NUM_DIGITS; i++) {
            int targetDigit = numberList.get(i);
            int guessDigit = Character.getNumericValue(userInput.charAt(i));

            if (targetDigit == guessDigit) {
                strike++;
            } else if (numberList.contains(guessDigit)) {
                ball++;
            }
        }
        return strike + ball * 10;
    }
    private String printResult(int result) {
        if (result == NUM_DIGITS) {
            return "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }
        if (result > 0) {
            int ball = result / 10;
            int strike = result % 10;
            return ball + "볼 " + strike + "스트라이크";
        }
        return "낫싱";
    }
    private void validateNumber(String input) {
        if (input.length() != NUM_DIGITS) {
            throw new IllegalArgumentException("3자리 숫자를 입력하세요.");
        }
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("숫자만 입력하세요.");
        }
        if (input.chars().distinct().count() != NUM_DIGITS) {
            throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.");
        }
    }
    private boolean choiceRestart() {
        System.out.println("게임을 새로 시작하려면 " + RESTART + ", 종료하려면 " + EXIT + "를 입력하세요.");
        String input = Console.readLine();

        if (input.equals(String.valueOf(RESTART))) {
            System.out.println("게임을 재시작합니다.");
            return true;
        }
        if (input.equals(String.valueOf(EXIT))) {
            System.out.println("게임을 종료합니다.");
            return false;
        }
        System.out.println("잘못된 입력입니다. 게임을 종료합니다.");
        return false;
    }
}
