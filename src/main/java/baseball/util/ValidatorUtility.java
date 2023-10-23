package baseball.util;

public class ValidatorUtility {
    private final NumberUtility numberUtility;

    public ValidatorUtility(){
        numberUtility = new NumberUtility();
    }

    public int[] getNumberUtility(String playerNumber, String computerNumber) {
        return numberUtility.getNumberUtility(playerNumber,computerNumber);
    }

    public boolean ThreeStrike(){
        return numberUtility.getStrike() == 3;
    }
}
