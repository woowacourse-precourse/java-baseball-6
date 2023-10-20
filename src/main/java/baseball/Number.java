package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Number {

    public Number() {
    }

    private static final int NUMBER_LENGTH = 3;
    private static final String END_INPUT1 = "1";
    private static final String END_INPUT2 = "2";

    /**
     * 랜덤 숫자를 생성하는 메서드
     */
    public List<Integer> generateRandomNumber() {

        List<Integer> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!(randomNumbers.contains(randomNumber))) {
                randomNumbers.add(randomNumber);
            }
        }

        return randomNumbers;
    }

    private String readInput() {
        return Console.readLine();
    }

    /**
     * 사용자의 입력을 list<integer>로 변환하는 메서드
     */
    public List<Integer> inputNumber() {

        String input = readInput();
        int number = parseInt(input);
        validateInput(input);

        return getDigit(number);
    }

    /**
     * 사용자의 입력을 검증 후 String으로 반환하는 메서드
     */
    public String inputEndNumber() {

        String input = readInput();
        validateEndInput(input);

        return input;
    }

    /**
     * int -> list<integer> 변환 메서드
     */
    private List<Integer> getDigit(int number) {

        List<Integer> digits = new ArrayList<>();

        int digit1 = number / 100;
        int digit2 = (number % 100) / 10;
        int digit3 = number % 10;

        digits.add(digit1);
        digits.add(digit2);
        digits.add(digit3);

        return digits;
    }

    /**
     * string -> int 변환 메서드
     */
    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다. 정수를 입력해주세요.");
        }
    }

    private void validateLength(String input) {
        if (input.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException("잘못된 길이의 값을 입력했습니다. 3자리 정수를 입력해주세요.");
        }

    }

    private void validateRange(String input) {
        if (input.contains("0")) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다. 0을 포함하지 않는 3자리 정수를 입력해주세요.");
        }
    }

    private void validateNoDuplication(String input) {

        Set<Character> inputs = new HashSet<>();

        for (char a : input.toCharArray()) {
            inputs.add(a);
        }

        if (inputs.size() != input.length()) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다. 중복 되지 않는 정수를 입력해주세요.");
        }
    }

    private void validateInput(String input) {
        validateLength(input);
        validateRange(input);
        validateNoDuplication(input);
    }

    private void validateEndInput(String input) {
        if (!(input.equals(END_INPUT1) || input.equals(END_INPUT2))) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다. 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
    }

}
