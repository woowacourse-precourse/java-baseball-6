package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GenComputerNum {
    List<String> computerNum = new ArrayList<>(); // 컴퓨터가 생성한 3자리 숫자

    public List<String> genComputerNum() {
        while (computerNum.size() < 3) { // 3개의 숫자 생성 시까지 반복
            int computerNum = Randoms.pickNumberInRange(1, 9);

            if (!this.computerNum.contains(String.valueOf(computerNum))) { // 중복된 숫자가 아니라면 List에 추가
                this.computerNum.add(String.valueOf(computerNum));
            }
        }
        return computerNum; // 컴퓨터 3자리 숫자 반환
    }
}
