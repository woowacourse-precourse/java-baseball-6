package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class GuessNumberFromUser {

    private final static String requestMessage = "숫자를 입력해주세요 : ";

    public List<Integer> getGuessNumber() throws IllegalArgumentException {
        String inputString = getInputString();
        List<Integer> guessNumber = StringToIntegerList(inputString);
        if (!validate(guessNumber)) {
            throw new IllegalArgumentException();
        }

        return guessNumber;
    }

    private String getInputString() {
        requestForGuessNumber();
        return Console.readLine();
    }

    private void requestForGuessNumber() {
        System.out.print(requestMessage);
    }

    private List<Integer> StringToIntegerList(String str) {
        return Arrays.stream(str.split(""))
            .map(Integer::parseInt)
            .toList();
    }


    private boolean validate(List<Integer> guessNumber) {
        return sizeValidate(guessNumber)
            && numberRangeValidate(guessNumber)
            && distinctValidate(guessNumber);
    }

    private boolean sizeValidate(List<Integer> guessNumber) {
        return guessNumber.size() == 3;
    }

    private boolean numberRangeValidate(List<Integer> guessNumber) {
        return guessNumber.stream().allMatch(num -> num > 0 && num < 10);
    }

    private boolean distinctValidate(List<Integer> guessNumber) {
        HashSet<Integer> setGuessNumber = new HashSet<>(guessNumber);
        return guessNumber.size() == setGuessNumber.size();
    }

}