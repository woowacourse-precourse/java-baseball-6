package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNum {
    List<String> computerNumList = new ArrayList<>(); // 컴퓨터가 생성한 3자리 숫자

    public List<String> genComputerNum(List<String> computerNumList) {
        while (computerNumList.size() < 3) { // 3개의 숫자 생성 시까지 반복
            int computerNum = Randoms.pickNumberInRange(1, 9);

            if (!this.computerNumList.contains(String.valueOf(computerNum))) { // 중복된 숫자가 아니라면 List에 추가
                this.computerNumList.add(String.valueOf(computerNum));
            }
        }
        return computerNumList; // 컴퓨터 3자리 숫자 반환
    }
}
