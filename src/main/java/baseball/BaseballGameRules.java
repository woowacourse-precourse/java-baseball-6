package baseball;

public class BaseballGameRules {

    private final int minNumber;
    private final int maxNumber;
    private final int numberCount;

    public BaseballGameRules(int minNumber, int maxNumber, int numberCount) {
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
        this.numberCount = numberCount;
    }

    public int getMinNumber() {
        return minNumber;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public int getNumberCount() {
        return numberCount;
    }
}
