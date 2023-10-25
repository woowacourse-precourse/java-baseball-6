package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    // 컴퓨터의 랜덤한 번호를 담을 리스트
    private List<Integer> computerBall = new ArrayList<>();

    // 컴퓨터 인스턴스가 생성되면 랜덤으로 번호 생성
    public void initComputerBall() {
        while (computerBall.size() < 3) {
            int newBall = Randoms.pickNumberInRange(1, 9);
            exceptDuplicateNum(newBall);
        }
    }

    // 번호의 중복을 제거하는 메서드
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
