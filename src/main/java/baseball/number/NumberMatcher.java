package baseball.number;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class NumberMatcher {

    private static final int MIN_VALID_NUMBER = 100;
    private static final int MAX_VALID_NUMBER = 999;
    private static final int NUMBER_LENGTH = 3;

    /**
     * 숫자 매칭
     * @param computer
     * @return
     */
    public static String numberMatcherResult(List<Integer> computer) {
        List<Integer> userInputList = getUserInputAsList();

        int strikeCount = countStrikes(userInputList, computer);
        int ballCount = countBalls(userInputList, computer);

        return formatResult(strikeCount, ballCount);
    }

    /**
     * 사용자가 입력한 숫자를 List로 반환
     * @return
     */
    private static List<Integer> getUserInputAsList() {
        int inputNumber = readValidUserInput();
        return convertNumberToList(inputNumber);
    }

    /**
     * 유효한 사용자 입력을 int로 반환
     * @return
     */
    private static int readValidUserInput() {
        int inputNumber = 0;
        try {
            inputNumber = Integer.parseInt(Console.readLine());
            if (!isValidNumber(inputNumber)) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return inputNumber;
    }

    /**
     * 입력 받은 숫자를 List로 반환
     * @param number
     * @return
     */
    private static List<Integer> convertNumberToList(int number) {
        List<Integer> result = new ArrayList<>();
        while (number > 0) {
            result.add(0, number % 10);
            number /= 10;
        }
        return result;
    }

    /**
     * 사용자가 입력한 숫자와 컴퓨터가 생성한 숫자 중
     * 같은 수가 같은 자리에 있는 스트라이크 개수 반환
     * @param userInput
     * @param computer
     * @return
     */
    private static int countStrikes(List<Integer> userInput, List<Integer> computer) {
        int count = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (userInput.get(i).equals(computer.get(i))) {
                count++;
            }
        }
        return count;
    }

    /**
     * 사용자가 입력한 숫자와 컴퓨터가 생성한 숫자 중
     * 같은 수가 다른 자리에 있는 볼 개수 반환
     * @param userInput
     * @param computer
     * @return
     */
    private static int countBalls(List<Integer> userInput, List<Integer> computer) {
        int count = 0;
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (!userInput.get(i).equals(computer.get(i)) && computer.contains(userInput.get(i))) {
                count++;
            }
        }
        return count;
    }

    /**
     * 볼, 스트라이크 개수를 문자 형태로 변환하여 반환
     * @param strikes
     * @param balls
     * @return
     */
    private static String formatResult(int strikes, int balls) {
        if (strikes == 0 && balls == 0) {
            return "낫싱";
        }
        return (balls > 0 ? balls + "볼 " : "") + (strikes > 0 ? strikes + "스트라이크" : "").trim();
    }

    /**
     * 숫자가 범위 내에 있는 유효한 숫자인지 체크
     * @param number
     * @return
     */
    public static boolean isValidNumber(int number) {
        return number >= MIN_VALID_NUMBER && number <= MAX_VALID_NUMBER && isAllDigitsBetween1And9(number);
    }

    /**
     * 입력한 숫자 값이 1~9 사이에 있는지 체크
     * @param number
     * @return
     */
    public static boolean isAllDigitsBetween1And9(int number) {
        while (number > 0) {
            int digit = number % 10;
            if (digit < 1 || digit > 9) {
                return false;
            }
            number /= 10;
        }
        return true;
    }
}

