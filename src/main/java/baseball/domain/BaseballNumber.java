package baseball.domain;

import java.util.List;

public class BaseballNumber {
    private final List<Integer> baseballNumberList;

    BaseballNumber(List<Integer> baseballNumberList){
        this.baseballNumberList = baseballNumberList;
    }

    // 인덱스의 숫자를 반환하는 기능
    public Integer getIndexNumber(int index){
        return baseballNumberList.get(index);
    }

    public boolean contains(int number) {
        return baseballNumberList.contains(number);
    }
}
