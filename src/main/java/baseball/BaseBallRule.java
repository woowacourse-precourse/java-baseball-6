package baseball;

public class BaseBallRule implements GameRule{

    public static final int ALL_STRIKE=3;
    @Override
    public boolean isRulePass(int strike) {
        if(strike==ALL_STRIKE){
            return true;
        }

        return false;
    }
}
