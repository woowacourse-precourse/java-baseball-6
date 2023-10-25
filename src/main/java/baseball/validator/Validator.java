package baseball.validator;

public class Validator {
    private final NumberCompare numberCompare;

    public Validator() {
        numberCompare = new NumberCompare();
    }

    public int[] getNumberCompare(String answerNumber, String Player){

        return numberCompare.getNumberCompare(answerNumber, Player);
    }

    public boolean isThreeStrike() {
        if (numberCompare.getStrike() == 3) {
            return true;
        }
        return false;
    }
}
