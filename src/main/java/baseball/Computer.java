package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

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

        return selectedNumbers.stream()
                .mapToInt(Integer::intValue)
                .reduce(0, (a, b) -> a * 10 + b);
    }

    /**
     * 입력값을 평가한다.
     *
     * @param input 입력값
     */
    public void evaluate(String input) {
        if (isNaN(input) || isNotUnique(input) || isNotNaturalNumber(input) || input.length() != 3) {
            throw new IllegalArgumentException();
        }
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
