package baseball.model.validator;

public class Validator {
    private final NumberCompare numberCompare;

    public Validator() {
        numberCompare = new NumberCompare();
    }

    public int[] getNumberCompare(String answer, String player) {
        return numberCompare.getNumberCompareResult(answer, player);
    }

    public boolean threeStrike() {
        return numberCompare.getStrike() == 3;
    }
}
