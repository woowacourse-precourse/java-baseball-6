package baseball;

public class Configurations {
    private int minimumOfRange;
    private int maximumOfRange;
    private int numberOfNumbers;
    private int playOption;
    private int endOption;

    Configurations() {
        minimumOfRange = 1;
        maximumOfRange = 9;
        numberOfNumbers = 3;
        playOption = 1;
        endOption = 2;
    }

    public int getMinimumOfRange() {
        return minimumOfRange;
    }

    public int getMaximumOfRange() {
        return maximumOfRange;
    }

    public int getNumberOfNumbers() {
        return numberOfNumbers;
    }

    public int getPlayOption() {
        return playOption;
    }

    public int getEndOption() {
        return endOption;
    }


}
