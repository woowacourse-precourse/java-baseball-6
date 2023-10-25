package baseball;

public class CompareScore {
    private final NumberValidator compareNumber;

    public CompareScore() {
        compareNumber = new NumberValidator();
    }

    public int[] getNumberCompare(String computerNumber, String playerNumber) {
        return compareNumber.compareResult(computerNumber, playerNumber);
    }

    public boolean isSuccess() {
        if (compareNumber.getStrikeNum() == 3) {
            return true;
        }
        return false;
    }

}
