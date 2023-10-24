package baseball.config;

public class GameConfiguration {
    private int minimumNumber;
    private int maximumNumber;
    private int numberOfDigits;

    private GameConfiguration() {

    }

    public int getMinimumNumber() {
        return minimumNumber;
    }

    public void setMinimumNumber(int minimumNumber) {
        this.minimumNumber = minimumNumber;
    }

    public int getMaximumNumber() {
        return maximumNumber;
    }

    public void setMaximumNumber(int maximumNumber) {
        this.maximumNumber = maximumNumber;
    }

    public int getNumberOfDigits() {
        return numberOfDigits;
    }

    public void setNumberOfDigits(int numberOfDigits) {
        this.numberOfDigits = numberOfDigits;
    }

    public GameConfiguration(int minimumNumber, int maximumNumber, int numberOfDigits) {
        this.minimumNumber = minimumNumber;
        this.maximumNumber = maximumNumber;
        this.numberOfDigits = numberOfDigits;
    }
}
