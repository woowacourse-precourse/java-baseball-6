package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballNumbers {
    static final int MIN_NUMBER = 1;
    static final int MAX_NUMBER = 9;
    static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    static List<BaseballNumber> byRandom(int digitSize) {
        List<BaseballNumber> numbers = new ArrayList<>();
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, digitSize);
        for (int randomNumber : randomNumbers) {
            numbers.add(new BaseballNumber(randomNumber));
        }
        return numbers;
    }

    static List<BaseballNumber> byInput(int digitSize) {
        System.out.print(INPUT_MESSAGE);
        String input = Console.readLine();
        try {
            validateInput(input, digitSize);
            return generateNumbers(input.split(""));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void validateInput(String input, int digitSize) {
        if (input.length() != digitSize) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateDuplicate(List<BaseballNumber> numbers, BaseballNumber number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException();
        }
    }

    private static List<BaseballNumber> generateNumbers(String[] input) {
        List<BaseballNumber> numbers = new ArrayList<>();
        for (String str : input) {
            BaseballNumber number = new BaseballNumber(str);
            validateDuplicate(numbers, number);
            numbers.add(number);
        }
        return numbers;
    }
}
