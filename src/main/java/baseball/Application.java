package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 1. 랜덤 번호 선택
        List<Integer> example = Randoms.pickUniqueNumbersInRange(1,9,3);
        System.out.println("example = " + example);
    }
}
