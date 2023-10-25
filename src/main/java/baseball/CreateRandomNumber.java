package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class CreateRandomNumber {
    public List<Integer> MakeRandomNumber(){
        // 컴퓨터가 만들 3자리수를 저장할 배열 선언
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            // 1에서 9까지 임의의 숫자를 3개를 선정한다.
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            // computer 배열 내부에 존재하는 값이 겹치지 않을 경우 배열에 넣는다.
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
