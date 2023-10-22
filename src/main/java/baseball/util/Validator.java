package baseball.util;

public class Validator {
    private final NumberCompare numberCompare;

    public Validator(){
        numberCompare = new NumberCompare();
    }

    public int[] getNumberCompare(String playerNumber, String computerNumber){
        return numberCompare.getResultCount(playerNumber,computerNumber);
    }

    public boolean isThreeStrike(){
        if(numberCompare.getStrike() == 3){
            return true;
        }
        return false;
    }
}
