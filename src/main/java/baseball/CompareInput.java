package baseball;

import java.util.ArrayList;
import java.util.List;

public class CompareInput {
    private final List<Integer> answer;
    private final int digits;

    public CompareInput(List<Integer> answer, int digits){
        this.answer = answer;
        this.digits = digits;
    }

    public List<Integer> countMatch(List<Integer> input){
        List<Integer> ballCount = new ArrayList<>(List.of(0, 0));
        for (int i = 0; i < digits; i++){
            if (input.get(i).equals(answer.get(i))) {
                ballCount.set(1, ballCount.get(1) + 1);
            }
            else if (answer.contains(input.get(i))){
                ballCount.set(0, ballCount.get(0) + 1);
            }
        }
        return ballCount;
    }
}
