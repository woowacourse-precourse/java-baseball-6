package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

/**
 * 세자리 난수를 생성하는 클래스
 */
public class Generator {
    private List<Integer> numList = new ArrayList<>();

    /**
     * numList 초기화
     */
    public Generator() {
        pickRandomNum();
    }

    /**
     * 세 개의 서로 다른 수 뽑고 numList에 저장
     */
    private void pickRandomNum() {
        while (numList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numList.contains(randomNumber)) {
                numList.add(randomNumber);
            }
        }
    }

    /**
     * numList에 저장된 세 개의 수를 문자열로 합쳐서 반환
     *
     * @return 문자열로 변환한 세자리 난수
     */
    public String generateNum() {
        StringBuilder s = new StringBuilder(3);
        for (Integer i : numList) {
            s.append(i);
        }
        String num = s.toString();
        return num;
    }


}
