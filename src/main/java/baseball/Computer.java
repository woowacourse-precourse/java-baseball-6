package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;

public class Computer {

    private final int digits;

    public Computer(int digitNumber) {
        this.digits = digitNumber;
    }

    /**
     * 다음을 만족하는 임의의 수를 생성한다.
     *
     * <p>1. 임의의 수는 서로 다른 수이다.<br>
     * 2. 임의의 수의 각 자리수는 0이 아닌 자연수이다.
     *
     * @return 생성된 임의의 수
     */
    public int generateRandomNumbers() {
        if (digits < 1 || digits > 8) {
            throw new IllegalArgumentException();
        }
        ArrayList<Integer> selectedNumbers = new ArrayList<>();

        while (selectedNumbers.size() < digits) {
            int n = Randoms.pickNumberInRange(1, 9);

            if (!selectedNumbers.contains(n)) {
                selectedNumbers.add(n);
            }
        }

        return selectedNumbers.stream().mapToInt(Integer::intValue).reduce(0, (a, b) -> a * 10 + b);
    }

    /**
     * 입력값을 평가한다.
     *
     * @param input 입력값
     */
    public String evaluate(String input, String targetNumber) {
        if (isNaN(input) || isNotUnique(input) || isNotNaturalNumber(input) || input.length() != 3) {
            throw new IllegalArgumentException();
        }
        int[] candidates = candidateNumbers(input, targetNumber);
        int numberOfStrikes = numberOfStrikes(targetNumber, input, candidates);
        int numberOfBalls = candidates.length - numberOfStrikes;
        return Prompt.printResult(numberOfBalls, numberOfStrikes);
    }

    private int[] candidateNumbers(String input, String targetNumber) {
        return input.chars().filter(c -> containsDigit(targetNumber, c)).toArray();
    }

    private int numberOfStrikes(String targetNumber, String input, int[] numbers) {
        return (int) Arrays.stream(numbers).filter(c -> isOnSamePosition(targetNumber, input, c)).count();
    }

    private boolean isOnSamePosition(String targetNumber, String input, int ch) {
        return targetNumber.indexOf(ch) == input.indexOf(ch);
    }

    /**
     * 입력값에 특정 숫자가 포함되어 있는지 확인한다.
     *
     * @param input 입력값
     * @param ch    특정 숫자
     * @return 입력값에 특정 숫자가 포함되어 있으면 참, 없으면 거짓
     */
    private boolean containsDigit(String input, int ch) {
        return input.indexOf(ch) != -1;
    }

    /**
     * 입력값이 숫자가 아닌지 확인한다.
     *
     * @param input 입력값
     * @return 입력값이 숫자가 아니면 참, 숫자이면 거짓
     */
    private boolean isNaN(String input) {
        if (input == null) {
            return true;
        }
        return !input.chars().allMatch(Character::isDigit);
    }

    /**
     * 입력값에 중복되는 숫자가 있는지 확인한다.
     *
     * @param input 입력값
     * @return 입력값에 중복되는 숫자가 있으면 참, 없으면 거짓
     */
    private boolean isNotUnique(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        return input.chars().distinct().count() != input.length();
    }

    /**
     * 입력값에 0이 있는지 확인한다.
     *
     * @param input 입력값
     * @return 입력값에 0이 있으면 참, 없으면 거짓
     */
    private boolean isNotNaturalNumber(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        return input.chars().anyMatch(c -> c == '0');
    }
}
