package baseball;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 게임 시작을 사용자에게 알린다.
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 컴퓨터 숫자 랜덤 생성
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
                //System.out.println(randomNumber + " ");
            }
        }

    }
}
