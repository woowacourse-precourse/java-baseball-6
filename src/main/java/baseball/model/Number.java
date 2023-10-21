package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

/**
 * @Class : 타겟 숫자 클래스
 * @auther : SYB
 * @since : 2023/10/21
 */
public class Number {

    List<Integer> target = new ArrayList<>();

    /**
     * @Method : 랜덤 숫자 생성(1~9, 서로 다른 3자리의 수)
     * @auther : SYB
     * @since : 2023/10/21
     */
    public void createRandomNumber() {
        while (target.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!target.contains(randomNumber)) {
                target.add(randomNumber);
            }
        }
    }


    /**
     * @Method : 사용자 입력 숫자 저장
     * @auther : SYB
     * @since : 2023/10/21
     */
    public void setUserNumberList(List<Integer> numberList) {
        if (validationNumber(numberList)) {
            this.target.addAll(numberList);
        } else {
            throw new IllegalArgumentException();
        }
    }


    /**
     * @Method : 숫자 검증(1~9 숫자, 서로 다른 3자리의 수)
     * @auther : SYB
     * @since : 2023/10/21
     */
    private static boolean validationNumber(List<Integer> numberList) {
        boolean range = numberList.stream().allMatch(n -> n >= 1 && n <= 9);
        boolean distinctSize = numberList.stream().distinct().count() == 3;
        return range && distinctSize;
    }


    /**
     * @Method : 타겟 숫자 초기화
     * @auther : SYB
     * @since : 2023/10/21
     */
    public void clear() {
        this.target.clear();
    }
}
