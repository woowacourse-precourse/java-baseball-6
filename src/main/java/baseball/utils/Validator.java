package baseball.utils;

public class Validator {
    private final CompareNumber compareNum;

    public Validator() {
        compareNum = new CompareNumber();
    }

    public int[] getCompareNumber(String answerNumber, String userNumber){

        return compareNum.getCompareNumberResult(answerNumber, userNumber);
    }

    public boolean isThreeStrike() {
        if (compareNum.getStrike() == 3) {
            return true;
        }
        return false;
    }

}
