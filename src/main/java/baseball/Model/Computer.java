package baseball.Model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> answer;

    public Computer(List<Integer> list) {
        answer = list;
    }

    public List<Integer> getAnswer() {
        return answer;
    }
}
