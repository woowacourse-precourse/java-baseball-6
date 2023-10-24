package baseball.number;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class NumberMatcher {

    /**
     * 숫자 매칭
     * @param computer
     * @return
     */
    public static String numberMatcherResult(
            List<Integer> computer,
            int startInclusive,
            int endInclusive,
            int count
    ) {
        List<Integer> userInputList = getUserInputAsList(startInclusive, endInclusive, count);

        int strikeCount = countStrikes(userInputList, computer, count);
        int ballCount = countBalls(userInputList, computer, count);

        return formatResult(strikeCount, ballCount);
    }

    /**
     * 사용자가 입력한 숫자를 List로 반환
     * @return
     */
    public static List<Integer> getUserInputAsList(
            int startInclusive,
            int endInclusive,
            int count
    ) {
        int inputNumber = readValidUserInput(startInclusive, endInclusive, count);
        return convertNumberToList(inputNumber);
    }

    /**
     * 유효한 사용자 입력을 int 반환
     * @return
     */
    public static int readValidUserInput(
            int startInclusive,
            int endInclusive,
            int count
    ) {
        int inputNumber = 0;
        try {
            inputNumber = Integer.parseInt(Console.readLine());
            if (!isValidNumber(inputNumber, startInclusive, endInclusive, count)) {
                throw new IllegalArgumentException("입력한 숫자는 범위 내에 있지 않거나 최소값 혹은 최대값 범위를 벗어났습니다.");
            }

            duplicatedInputCheck(inputNumber);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
        return inputNumber;
    }

    /**
     * 중복 숫자 확인
     * @param inputNumber
     */
    public static void duplicatedInputCheck(int inputNumber) {
        String strNumber = String.valueOf(inputNumber);

        for (int i = 0; i < strNumber.length(); i++) {
            char currentChar = strNumber.charAt(i);
            if (strNumber.indexOf(currentChar, i + 1) != -1) {
                throw new IllegalArgumentException("중복된 숫자가 있습니다: " + currentChar);
            }
        }
    }

    /**
     * 입력 받은 숫자를 List로 반환
     * @param number
     * @return
     */
    public static List<Integer> convertNumberToList(int number) {
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
    public static int countStrikes(List<Integer> userInput, List<Integer> computer, int numberLength) {
        int count = 0;
        for (int i = 0; i < numberLength; i++) {
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
    public static int countBalls(List<Integer> userInput, List<Integer> computer, int numberLength) {
        int count = 0;
        for (int i = 0; i < numberLength; i++) {
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
    public static String formatResult(int strikes, int balls) {
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
    public static boolean isValidNumber(
            int number,
            int startInclusive,
            int endInclusive,
            int count
    ) {
        // 1: 1 ~ 9
        // 2: 10 ~ 99
        // 3: 100 ~ 999
        int minValue = calculateMinValue(count);
        int maxValue = calculateMaxValue(count);
        return number >= minValue && number <= maxValue && isAllDigitsBetween(number, startInclusive, endInclusive);
    }

    /**
     * 자릿수의 최소값을 반환
     * @param digits
     * @return
     */
    public static int calculateMinValue(int digits) {
        if (digits == 1) {
            return 1;
        }
        return (int) Math.pow(10, digits - 1);
    }

    /**
     * 자릿수의 최대값을 반환
     * @param digits
     * @return
     */
    public static int calculateMaxValue(int digits) {
        return (int) Math.pow(10, digits) - 1;
    }

    /**
     * 입력한 숫자 값이 1~9 사이에 있는지 체크
     * @param number
     * @return
     */
    public static boolean isAllDigitsBetween(int number, int min, int max) {
        while (number > 0) {
            int digit = number % 10;
            if (digit < min || digit > max) {
                return false;
            }
            number /= 10;
        }
        return true;
    }

}

