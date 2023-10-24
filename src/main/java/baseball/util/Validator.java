package baseball.util;

public class Validator {
    private final NumberCompare numberCompare;

    public Validator() {
        numberCompare = new NumberCompare();
    }

    public int[] getNumberCompare(String answerNumber, String playerNumber){

        return numberCompare.getNumberCompareResult(answerNumber, playerNumber);
    }

    public boolean isThreeStrike() {
        if (numberCompare.getStrike() == 3) {
            return true;
        }
        return false;
    }

}