package baseball.utils;

public class Validator {
    private final NumberCompare numberCompare;

    public Validator() {
        numberCompare = new NumberCompare();
    }

    public int[] getNumberCompare(String playerNumber, String computerNumber) {
        return numberCompare.getCompareNumber(playerNumber, computerNumber);
    }

    public boolean idCorrect() {
        if (numberCompare.getStrike() == 3) {
            return true;
        }
        return false;
    }

}
