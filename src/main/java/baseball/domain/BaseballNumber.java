package baseball.domain;

import java.util.List;

public class BaseballNumber {
    private final List<Integer> baseballNumberList;

    // 3개의 숫자를 리스트로 저장하는 기능
    // 리스트가 현재 3개라는 보장이 없기 때문에 3개라는 것을 보장하기 위한 제약이 필요한 상태
    BaseballNumber(List<Integer> baseballNumberList){
        this.baseballNumberList = baseballNumberList;
    }

    // 인덱스의 숫자를 반환하는 기능
    public Integer getIndexNumber(int index){
        return baseballNumberList.get(index);
    }
}
