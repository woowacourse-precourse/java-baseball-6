package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

//3자리 자연수 무작위 생성
public class ComputerNumber {
    public List<Integer> generateNumber() {
        List<Integer> computerNumberList = new ArrayList<>();

        while (computerNumberList.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (!computerNumberList.contains(randomNum)) {
                computerNumberList.add(randomNum);
            }
        }

        return computerNumberList;
    }
}
