package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Input {
    private static final Output output = new Output();
    private ArrayList<Integer> userNumbers = new ArrayList<>();

    public ArrayList<Integer> inputUserNumbers() {
        userNumbers.clear();
        output.printInputMessage();
        String inputtedNumber = inputStringNumber();
        checkInputtedNumber(inputtedNumber);
        convertStringNumberToIntegerList(inputtedNumber);
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
        if(inputtedNumber.length() != BaseballGame.gameNumberDigits) {
            throw new IllegalArgumentException();
        }
    }

    private void checkNumbersDuplicate(String inputtedNumber) {
        StringBuilder stringForCheckingDuplicate = new StringBuilder();
        for (char number : inputtedNumber.toCharArray()) {
            if(stringForCheckingDuplicate.toString().contains(String.valueOf(number))) {
                throw new IllegalArgumentException();
            }
            stringForCheckingDuplicate.append(number);
        }
    }

    private void convertStringNumberToIntegerList(String inputtedNumber) {
        ArrayList<Integer> tempNumbers = new ArrayList<>();
        for(int numbersIndex=0; numbersIndex<inputtedNumber.length(); numbersIndex++) {
            char digitChar = inputtedNumber.charAt(numbersIndex);
            int digitNumber = Character.getNumericValue(digitChar);
            tempNumbers.add(digitNumber);
        }
        userNumbers = tempNumbers;
    }
}
