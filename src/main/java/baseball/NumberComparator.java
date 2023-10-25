package baseball;

import java.util.List;

public class NumberComparator {
    private int strike;
    private int ball;
    public void compare(List<Integer> listA, List<Integer> listB){
        this.strike=0;
        this.ball=0;
        for(int idx=0;idx<3;idx++){
            if (listA.get(idx)==listB.get(idx)){
                this.strike++;
            }
            else if(listA.contains(listB.get(idx))){
                this.ball++;
            }
        }
    }
    public int getStrike(){
        return this.strike;
    }
    public int getBall(){
        return this.ball;
    }
}
