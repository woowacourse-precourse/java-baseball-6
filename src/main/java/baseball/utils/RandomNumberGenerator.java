package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import static baseball.utils.Constants.*;

/*
 난수를 생성을 담당하는 클래스
 기능은 별로 없지만, 난수 생성을 이용한 기능이 추가로 생길 시를 대비해 유틸 클래스로 관리
 */

public class RandomNumberGenerator {

    private RandomNumberGenerator() {
    }

    /*
    1 ~ 9 안의 난수를 생성하는 함수
     */

    public static int pickRandomNaturalNumber() {
        return Randoms.pickNumberInRange(USER_ANSWER_LOWER_LIMIT, USER_ANSWER_UPPER_LIMIT);
    }

}
