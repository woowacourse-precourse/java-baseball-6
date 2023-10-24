package baseball.model;

public class Referee {

    private final Hint hint;
    public Referee(){
        hint = new Hint();
    }
    public int[] getHint(String userNumber, String answerNumber){
        return hint.getHint(userNumber, answerNumber);
    }

    public boolean isThreeStrike() {
        if(hint.getStrike() == 3) {
            return true;
        }
        return false;
    }

}
