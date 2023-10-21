package baseball.util;

import java.util.List;

public class Verification {
    private final Compare compare;
    public Verification() {
        compare = new Compare();
    }

    public List<Integer> getCompare(List<Integer> userNumber,List<Integer> computerNumber){
        return compare.numberCompare(userNumber,computerNumber);
    }
    public boolean threeStrike(){
        if(compare.getStrike()==3){
            return true;
        }
        return false;
    }

}
