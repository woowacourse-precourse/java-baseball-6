package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private static final int MAX_NUMBER_LENGTH = BaseballValues.MAX_NUMBER_LENGTH.getValue();
    private static final int MIN_NUMBER = BaseballValues.MIN_NUMBER.getValue();
    private static final int MAX_NUMBER = BaseballValues.MAX_NUMBER.getValue();

    private final List<Integer> numbers;

    Player() {
        this.numbers = new ArrayList<>();
    }

    Player(List<Integer> numbers) {
        this.numbers = numbers;
    }

    List<Integer> getNumbers() {
        return numbers;
    }

    void initNumbers() {
        numbers.clear();

        String inputNumbers = getInputNumbers();

        for (int i = 0; i < inputNumbers.length(); i++) {
            int number = Character.getNumericValue(inputNumbers.charAt(i));

            checkInputNumberRange(number);

            numbers.add(number);
        }
    }

    private String getInputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputNumbers = readLine();

        if (inputNumbers.length() != MAX_NUMBER_LENGTH) {
            throw new IllegalArgumentException("입력한 숫자 길이가 맞지 않습니다.");
        }

        return inputNumbers;
    }

    private void checkInputNumberRange(int number) {
        if (MIN_NUMBER > number || number > MAX_NUMBER) {
            throw new IllegalArgumentException("입력한 문자는 숫자가 아닙니다.");
        }
    }
}
