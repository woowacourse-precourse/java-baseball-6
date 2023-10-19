package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Judger {
    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void compareNumbers(List<Integer> human, List<Integer> computer) {
        List<Integer> result = new ArrayList<>(Arrays.asList(0, 0, 0));
        for(int i = 0; i < 3; i ++){
            if(isStrike(human.get(i), computer.get(i))) {
                result.set(0, result.get(0) + 1);
            }
        }
    }

    private boolean isStrike(int human, int computer){
        return human == computer;
    }
}
