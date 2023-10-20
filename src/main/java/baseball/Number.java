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

    private Console console;
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String ASK_FOR_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final int LENGTH = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    /**
     * 컴퓨터가 랜덤 3자리 숫자를 생성하는 메서드
     */
    public List<Integer> setRandomNumber() {

        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            computer.add(randomNumber);
        }

        return computer;
    }

    /**
     * 사용자의 입력을 받아 list<integer>로 변환하는 함수
     */
    public List<Integer> inputNumber() {

        System.out.println(START_MESSAGE);
        System.out.print(ASK_FOR_NUMBER_MESSAGE);
        String input = console.readLine();

        int number = parseInt(input);

        isValidLength(input);
        isValidRange(input);
        isNotDuplicated(input);

        return getDigit(number);
    }

    /**
     * int -> list<integer> 변환 함수
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
     * string -> int 변환 함수
     */
    private int parseInt(String input) {
        try {
            int number = Integer.parseInt(input);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다. 3자리 정수를 입력해주세요.");
        }
    }

    private void isValidLength(String input) {
        if (input.length() != LENGTH) {
            throw new IllegalArgumentException("잘못된 길이의 값을 입력했습니다. 3자리 정수를 입력해주세요.");
        }

    }

    private void isValidRange(String input) {
        if (input.contains("0")) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다. 0을 포함하지 않는 3자리 정수를 입력해주세요.");
        }
    }

    private void isNotDuplicated(String input) {

        Set<Character> inputs = new HashSet<>();

        for (char a : input.toCharArray()) {
            inputs.add(a);
        }

        if (inputs.size() != input.length()) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다. 중복 되지 않는 정수를 입력해주세요.");
        }

    }

}
