package baseball.domain;

import java.util.List;

public class BaseballNumber {
    private final List<Integer> baseballNumberList;

    BaseballNumber(List<Integer> baseballNumberList){
        this.baseballNumberList = baseballNumberList;
    }

    public Integer getIndexNumber(int index){
        return baseballNumberList.get(index);
    }

    public int getSize(){
        return baseballNumberList.size();
    }

    public boolean contains(int number) {
        return baseballNumberList.contains(number);
    }
}
