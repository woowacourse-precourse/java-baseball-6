package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

//랜덤으로 숫자 3개 생성
public class RandomNum {
    public List<Integer> randomNum(){
        List<Integer> computer = new ArrayList<>();
        while(computer.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNum)) {
                computer.add(randomNum);
            }
        }
        return computer;
    }
}
