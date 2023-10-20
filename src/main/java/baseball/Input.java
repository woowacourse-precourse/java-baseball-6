package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Input {
    private static final Output output = new Output();
    private final ArrayList<Integer> userNumbers = new ArrayList<>();

    public ArrayList<Integer> inputUserNumbers() {
        userNumbers.clear();
        output.printInputMessage();
        String inputtedNumber = inputStringNumber();
        checkInputtedNumber(inputtedNumber);
        convertStringToIntegerList(inputtedNumber);
        return userNumbers;
    }

    private String inputStringNumber() {
        return Console.readLine();
    }

    private void checkInputtedNumber(String inputtedNumber) {
        checkNumbersDigit(inputtedNumber);
        checkNumbersDuplicate(inputtedNumber);
    }

    private void checkNumbersDigit(String inputtedNumber) {
        if(inputtedNumber.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private void checkNumbersDuplicate(String inputtedNumber) {
        String stringForCheckingDuplicate = "";
        for (char number : inputtedNumber.toCharArray()) {
            if(stringForCheckingDuplicate.contains(String.valueOf(number))) {
                throw new IllegalArgumentException();
            }
            stringForCheckingDuplicate += number;
        }
    }

    private void convertStringToIntegerList(String inputtedNumber) {
        for(int numbersIndex=0; numbersIndex<3; numbersIndex++) {
            char digitChar = inputtedNumber.charAt(numbersIndex);
            int digitNumber = Character.getNumericValue(digitChar);
            userNumbers.add(digitNumber);
        }
    }
}
