package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static baseball.constant.NumberConstant.*;
import static baseball.constant.TextConstant.*;
import static java.util.stream.Collectors.*;

public class NumberCreator {

    private NumberCreator() {
    }

    public static NumberCreator initGame() {
        return new NumberCreator();
    }

    public List<Integer> getComputerNumber() {
        List<Integer> computerNumber = new ArrayList<>();

        while (computerNumber.size() < MAX_COMPUTER_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }

        return computerNumber;
    }

    public List<Integer> getGuessNumber() {
        String inputNumberString = Console.readLine();
        String[] splitNumber = inputNumberString.split(SPLIT_UNIT);

        List<Integer> numbers = Arrays.stream(splitNumber)
                .map(Integer::parseInt)
                .collect(toList());

        validateInput(numbers);

        return numbers;
    }

    private void validateInput(final List<Integer> numbers) {
        if (numbers.size() != THREE_DIGITS) {
            throw new IllegalArgumentException(GUESS_NUMBER_LENGTH_EXCEPTION);
        }

        if (numbers.contains(ZERO)) {
            throw new IllegalArgumentException(GUESS_NUMBER_RANGE_EXCEPTION);
        }

        Stream<Integer> numberStream = numbers.stream();
        Stream<Integer> distinctNumberStream = numberStream.distinct();

        if (distinctNumberStream.count() != THREE_DIGITS) {
            throw new IllegalArgumentException(GUESS_NUMBER_DUPLICATION);
        }
    }
}
