package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNum {
    List<String> computerNumList = new ArrayList<>(); // 컴퓨터가 생성한 3자리 숫자

    public List<String> genComputerNum() {
        computerNumList.clear(); // 리스트 초기화
        while (computerNumList.size() < 3) {
            int computerNum = Randoms.pickNumberInRange(1, 9);
            if (!this.computerNumList.contains(String.valueOf(computerNum))) {
                this.computerNumList.add(String.valueOf(computerNum));
            }
        }
        return computerNumList;
    }
}