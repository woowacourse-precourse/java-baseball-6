package baseball;

public class Validator {
    private final CompareNumber compareNumber;

    public Validator() {
        compareNumber = new CompareNumber();
    }

    public int[] getNumberCompare(String computerNumber, String playerNumber) {
        return compareNumber.compareResult(computerNumber, playerNumber);
    }

    public boolean isThreeStrike() {
        if (compareNumber.getStrike() == 3) {
            return true;
        }
        return false;
    }

}
