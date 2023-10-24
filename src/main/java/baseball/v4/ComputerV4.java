package baseball.v4;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

// 컴퓨터의 랜덤한 숫자를 설정하는 클래스
public class ComputerV4 implements SetNumV4 {
    // Computer가 1~9 범위에서 랜덤한 3개의 숫자를 설정하고 반환하는 메서드
    public List<Integer> setNum() {
        List<Integer> computerNum = new ArrayList<>();
        while (computerNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber);
            }
        }
        return computerNum;
    }
}
