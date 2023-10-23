package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> computerBall = new ArrayList<>();

    // 컴퓨터 인스턴스가 생성되면 랜덤으로 번호 생성
    public void initComputerBall() {
        while (computerBall.size() < 3) {
            int newBall = Randoms.pickNumberInRange(1, 9);
            exceptDuplicateNum(newBall);
        }
    }

    public void exceptDuplicateNum(int newBall) {
        if (!computerBall.contains(newBall)) {
            computerBall.add(newBall);
        }
    }

    public Computer() {
        initComputerBall();
    }

    public List<Integer> getComputerBall() {
        return computerBall;
    }
}
