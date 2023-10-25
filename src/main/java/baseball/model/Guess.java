package baseball.model;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Guess {

    private Integer guess1;

    private Integer guess2;

    private Integer guess3;

    // waitUserGuess : 유저의 추측을 형식에 맞춰 입력받는다.
    public void waitUserGuess() throws IllegalArgumentException {
        System.out.print("숫자를 입력해주세요 : ");
        String numberString = Console.readLine();
        try {
            parseNumber(Integer.valueOf(numberString));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Input must be Integer type");
        }
    }

    // isThreeDigits : 숫자가 3자리 양수인지 여부를 반환한다.
    private Boolean isThreeDigits(Integer number) {
        return number < 1000 && number > 99;
    }

    // isIncludeZero : 입력에 0이 하나라도 있는지 여부를 반환한다.
    private Boolean isIncludeZero(Integer number1, Integer number2, Integer number3) {
        return number1.equals(0) || number2.equals(0) || number3.equals(0);
    }

    // isUniqueNumbers : 숫자 3개가 서로 다른 숫자인지 검증한다. 서로 다른 숫자라면 True, 같은 숫자가 하나라도 있다면 False를 반환한다.
    private Boolean isUniqueNumbers(Integer uniqueNumber1, Integer uniqueNumber2, Integer uniqueNumber3) {
        return !uniqueNumber1.equals(uniqueNumber2)
                && !uniqueNumber2.equals(uniqueNumber3)
                && !uniqueNumber3.equals(uniqueNumber1);
    }

    // parseNumber : 입력받은 정수를 3개의 (1<=x<=9)범위의 정수로 파싱한다.
    private void parseNumber(Integer number) throws IllegalArgumentException {
        if (!isThreeDigits(number)) {
            throw new IllegalArgumentException("numbers cannot less or more then 3 digits.");
        }
        guess3 = number % 10;
        number /= 10;
        guess2 = number % 10;
        number /= 10;
        guess1 = number % 10;
        if (isIncludeZero(guess1, guess2, guess3)) {
            throw new IllegalArgumentException("numbers cannot be zero.");
        } else if (!isUniqueNumbers(guess1, guess2, guess3)) {
            throw new IllegalArgumentException("numbers must be unique.");
        }
    }

    // getNumberList : 입력받은 Valid한 3개의 숫자를 순서대로 넣어서 List로 반환한다.
    public List<Integer> getNumberList() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(guess1);
        numbers.add(guess2);
        numbers.add(guess3);
        return numbers;
    }

}
