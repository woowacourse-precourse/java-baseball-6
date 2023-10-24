package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

/**
 * 컴퓨터 측에서 사용하는 유틸 클래스
 */
public class ComputerUtil {

    /**
     * 랜덤값 3자리 추출 메서드
     */
    public List<Integer> generateRandomNumber(){

        List<Integer> computerNumbers = new ArrayList<>();

        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }

        return computerNumbers;
    }

}
