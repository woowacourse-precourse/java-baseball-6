package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Baseball {

    public void play() { // 0. 게임을 실행하는 메서드

    }

    public static void pickThreeNumbers() { // 1. 컴퓨터가 가질 3개의 값을 초기화하는 메서드
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.println("computer = " + computer);
    }

    public void endGame() { // 2. 게임을 종료하는 메서드

    }


}
