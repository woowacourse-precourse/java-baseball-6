package baseball.domain;

import java.util.List;

public class BaseBallNumberList {

    public BaseBallNumberList(List<Integer> numberList) {
        if(numberList.size()!=3){
            throw new IllegalArgumentException("숫자를 3개를 입력해주세요");
        }
    }
}
