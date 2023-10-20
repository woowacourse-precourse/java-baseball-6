package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    // computeArr과 playerArr를 List 또는 배열 중 어떤 것을 선언하면 더 빠르게 조회할 수 있을까?
    // computer의 Ball은 숨겨야한다.
    List<Integer> computerBall = new ArrayList<>();

    // 컴퓨터 인스턴스가 생성되면 랜덤으로 번호 생성
    public void initComputerBall() {
        while(computerBall.size() < 3) {
            int newBall = Randoms.pickNumberInRange(1, 9);
            if(!computerBall.contains(newBall)) {
                computerBall.add(newBall);
            }
        }
    }

    public Computer() {
        initComputerBall();
    }

    public List<Integer> getComputerBall() {
        return computerBall;
    }
}
