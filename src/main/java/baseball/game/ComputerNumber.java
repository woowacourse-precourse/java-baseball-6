package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {
    // 컴퓨터에서 랜덤 숫자를 뽑음.
    private List<Integer> numberList = new ArrayList<>();

    public ComputerNumber() {
        while (numberList.size() < 3) { // 컴퓨터가 지정한 숫자 3개
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!numberList.contains(randomNumber)) { // 중복되는 수를 없애기 위해서
                numberList.add(randomNumber);
            }
        }

    }

    public List<Integer> getComputerNum() {
        return numberList;
    }
}

