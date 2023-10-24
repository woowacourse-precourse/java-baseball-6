package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballNumbers {
    static final int MIN_NUMBER = 1;
    static final int MAX_NUMBER = 9;

    static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    static List<BaseballNumber> selectByRandom(int size) {
        List<BaseballNumber> numbers = new ArrayList<>();
        while (numbers.size() < size) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            addNumber(numbers, randomNumber);
        }
        return numbers;
    }

    private static void addNumber(List<BaseballNumber> numbers, int number) {
        BaseballNumber baseballNumber = new BaseballNumber(number);
        if (!numbers.contains(baseballNumber)) {
            numbers.add(baseballNumber);
        }
    }

    static List<BaseballNumber> selectByInput(int size) {
        System.out.print(INPUT_MESSAGE);
        String input = Console.readLine();
        validateInput(input, size);
        return generateNumbers(input.split(""));
    }

    private static void validateInput(String input, int size) {
        if (input.length() != size) {
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
