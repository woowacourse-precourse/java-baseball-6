package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Number {

    public Number() {
    }

    private static final int NUMBER_LENGTH = 3;
    Validator validator = new Validator();

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
        validator.validateInput(input);

        return getDigit(number);
    }

    /**
     * 사용자의 입력을 검증 후 String으로 반환하는 메서드
     */
    public String inputEndNumber() {

        String input = readInput();
        validator.validateEndInput(input);

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

}
