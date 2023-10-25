package baseball.domain;

import java.util.List;

public class JudgeNumber {
    public int count(List<Integer> computer, List<Integer> player) {
        int result = 0;
        for (int i = 0; i < computer.size(); i++){
            if(player.contains(computer.get(i))){
                result++;
            }
        }
        return result;
    }

    public boolean isNumber() {
        return false;
    }
}
