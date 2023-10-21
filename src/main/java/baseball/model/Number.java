package baseball.model;

import java.util.ArrayList;
import java.util.List;

/**
 *  @Class   : 타겟 숫자 클래스
 *  @since   : 2023/10/21
 *  @auther  : SYB
 */
public class Number {

    List<Integer> target = new ArrayList<>();

    /**
     *  @Method  : 랜덤 숫자 생성(1~9, 서로 다른 3자리의 수)
     *  @since   : 2023/10/21
     *  @auther  : SYB
     */
    public void createRandomNumber(){
    }


    /**
     *  @Method  : 사용자 입력 숫자 저장(검증 기능 포함)
     *  @since   : 2023/10/21
     *  @auther  : SYB
     */
    public void setUserNumberList(List<Integer> numberList) {
        this.target.addAll(numberList);
    }


    /**
     *  @Method  : 타겟 숫자 초기화
     *  @since   : 2023/10/21
     *  @auther  : SYB
     */
    public void clear() {
        this.target.clear();
    }
}
