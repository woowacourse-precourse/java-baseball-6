package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Problem {

    private final List<Integer> answer;

    public Problem(){
        this.answer = createAnswer();
    }

    public List<Integer> makeProblem(){
        return answer;
    }

    public List<Integer> createAnswer(){
        return Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }

}
