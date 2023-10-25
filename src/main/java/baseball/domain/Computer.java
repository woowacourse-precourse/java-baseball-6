package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

/**
 * 랜덤 세 자리 수를 생성하는 컴퓨터 클래스 랜덤 수 추출을 위한 라이브러리 호출 pickNumberInRange(시작 범위, 끝 범위) : 한 자리 수 랜덤 추출 메서드
 */
public class Computer {

    private List<Integer> num;

    public Computer() {
        num = new ArrayList<>();
    }

    /**
     * 랜덤으로 서로 다른 세 자리 수를 추출하는 메서드
     *
     * @return
     */
    public List<Integer> make() {

        while (num.size() < 3) {
            int tmp = Randoms.pickNumberInRange(1, 9);
            if (!num.contains(tmp)) {
                num.add(tmp);
            }
        }
        return num;
    }
}
