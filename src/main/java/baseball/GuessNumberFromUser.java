package baseball;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class GuessNumberFromUser extends NumberFromUser<List<Integer>> {

    public GuessNumberFromUser() {
        outMessage = OutMessage.GUESS;
    }

    @Override
    protected List<Integer> convertToReturnType(String input) {
        return Arrays.stream(input.split(""))
            .map(Integer::parseInt)
            .toList();
    }

    @Override
    protected boolean validate() {
        return sizeValidate()
            && numberRangeValidate()
            && distinctValidate();
    }

    private boolean sizeValidate() {
        return value.size() == 3;
    }

    private boolean numberRangeValidate() {
        return value.stream().allMatch(num -> num > 0 && num < 10);
    }

    private boolean distinctValidate() {
        HashSet<Integer> setGuessNumber = new HashSet<>(value);
        return value.size() == setGuessNumber.size();
    }

}