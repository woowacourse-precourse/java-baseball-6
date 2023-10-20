package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        final List<String> computerNumbers = new ArrayList<>();

        // [기능 1] 컴퓨터가 1 - 9 서로 다른 임의의 수 3개 선택하는 기능
        for (int i = 0; i < 3; i++) {
            computerNumbers.add(String.valueOf(Randoms.pickNumberInRange(1, 9)));
        }
    }
}
