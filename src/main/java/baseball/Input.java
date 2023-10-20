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
        try {
            output.printInputMessage();
            String inputtedNumber =  Console.readLine();
            checkInputtedNumber(inputtedNumber);
            return inputtedNumber;
        } catch (IllegalArgumentException e) {
            System.out.printf("%d자리의 중복 되지 않는 적절한 수를 입력해주세요.\n", gameNumberDigits);
            return inputStringNumber();
        }
    }

    private void checkInputtedNumber(String inputtedNumber) {
            checkNumbersDigit(inputtedNumber);
            checkNumbersDuplicate(inputtedNumber);
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
        try{
            output.printSelectRestartMessage();
            String inputtedOption = Console.readLine();
            checkAppropriateOption(inputtedOption);
            return inputtedOption;
        } catch (IllegalArgumentException e) {
            System.out.println("1 또는 2를 입력해주세요.");
            return inputRestartOption();
        }
    }

    private void checkAppropriateOption(String inputtedOption) {
        if(!(inputtedOption.equals("1") | inputtedOption.equals("2"))) {
            throw new IllegalArgumentException();
        }
    }
}
