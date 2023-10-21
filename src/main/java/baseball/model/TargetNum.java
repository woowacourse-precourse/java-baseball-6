package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class TargetNum {
    private List<Integer> targetNum = new ArrayList<>();

    public TargetNum(List<Integer> num){
        this.targetNum=num;
    }
    public void setTargetNum(List<Integer> num){
        this.targetNum=num;
    }
    public List<Integer> getTargetNumArray(){
        return this.targetNum;
    }
}
