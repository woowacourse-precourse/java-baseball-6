package baseball;

public class Rule {
    private final int minNumber;
    private final int maxNumber;
    private final int numberOfDigits;

    private int endChoice = 1;
    private int continueChoice = 2;

    public Rule(int minNumber, int maxNumber, int numberOfDigits, int endChoice, int continueChoice) {
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
        this.numberOfDigits = numberOfDigits;
        this.endChoice = endChoice;
        this.continueChoice = continueChoice;
    }

    public int getMinNumber() {
        return minNumber;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public int getNumberOfDigits() {
        return numberOfDigits;
    }

    public boolean isValidNumber(int number) {
        String numberStr = String.valueOf(number);
        return number >= minNumber
                && number <= maxNumber
                && numberStr.length() == numberOfDigits
                && !numberStr.contains("0")
                && numberStr.chars().distinct().count() == numberOfDigits;
    }

    public boolean isValidChoice(int choice) {
        return choice == endChoice || choice == continueChoice;
    }
}
