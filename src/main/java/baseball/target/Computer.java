package baseball.target;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

/*
 *컴퓨터가 하는 일을 다루는 클래스
 */
public class Computer {
    /*
     *컴퓨터가 사용할 3자리 숫자를 만들어내는 메서드
     */
    public List<Integer> getNumber() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNum)) {
                computer.add(randomNum);
            }
        }

        return computer;
    }
}

