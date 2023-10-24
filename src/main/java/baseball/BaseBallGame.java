package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

/**
 * BaseBallGame.java
 *
 * 야구게임이 수행될 메인 부분
 *
 * @author Lee NaYeon
 * @since 2023-10-24
 */

public class BaseBallGame {

    public void start(){

        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> computer = createRandomNumber();

    }

    /**
     * 3자리 난수 생성
     * @return List<Integer> 타입의 3자리 난수
     */
    private static List<Integer> createRandomNumber(){

        List<Integer> list = new ArrayList<>();
        while (list.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!list.contains(randomNumber)) {
                list.add(randomNumber);
            }
        }

        return list;
    }

}
