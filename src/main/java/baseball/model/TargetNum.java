package baseball.model;

import java.util.List;

public class TargetNum {
    private List<Integer> targetNum;

    public TargetNum(List<Integer> num){
        this.targetNum=num;
    }
    public List<Integer> getTargetNumArray(){
        return this.targetNum;
    }
}
