package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class Answer {
    public static List<Integer> RandomAns()     //랜덤으로 정답값을 생성 주어진 예시가 List의 형식
    {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {

            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
