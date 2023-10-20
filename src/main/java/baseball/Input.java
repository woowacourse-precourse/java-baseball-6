package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Input {
    private static final int gameNumberDigits = BaseballGame.gameNumberDigits;
    private static final Output output = new Output();
    private ArrayList<Integer> userNumbers = new ArrayList<>();

    public ArrayList<Integer> inputUserNumbers() {
        userNumbers.clear();
        String inputtedNumber = inputStringNumber();
        convertStringNumberToIntegerList(inputtedNumber);
        return userNumbers;
    }

    private String inputStringNumber() {
            output.printInputMessage();
            String inputtedNumber =  Console.readLine();
            checkInputtedNumber(inputtedNumber);
            return inputtedNumber;
    }

    private void checkInputtedNumber(String inputtedNumber) {
            checkNumbersDigit(inputtedNumber);
            checkNumbersDuplicate(inputtedNumber);
            checkNumbersIncludeZero(inputtedNumber);
            checkNumbersIncludeNotNumber(inputtedNumber);
    }

    private void checkNumbersDigit(String inputtedNumber) {
        if(inputtedNumber.length() != gameNumberDigits) {
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

    private void checkNumbersIncludeZero(String inputtedNumber) {
        if(inputtedNumber.contains("0")) {
            throw new IllegalArgumentException();
        }
    }

    private void checkNumbersIncludeNotNumber(String inputtedNumber) {
        if(isNumeric(inputtedNumber) == false) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
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

    public String inputRestartOption() {
            output.printSelectRestartMessage();
            String inputtedOption = Console.readLine();
            checkAppropriateOption(inputtedOption);
            return inputtedOption;
    }

    private void checkAppropriateOption(String inputtedOption) {
        if(!(inputtedOption.equals("1") || inputtedOption.equals("2"))) {
            throw new IllegalArgumentException();
        }
    }
}
