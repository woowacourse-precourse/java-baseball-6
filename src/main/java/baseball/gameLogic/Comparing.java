package baseball.gameLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Comparing {
    public List<Integer> countComparison(List<Integer> randomNum, List<Integer> inputNum) {
        int strikeCount = 0, ballCount = 0;
        for(int i = 0; i < randomNum.size(); i++){
            for(int j = 0; j < randomNum.size(); j++){
                if (Objects.equals(randomNum.get(i), inputNum.get(j))) {
                    if (i == j) {
                        strikeCount += 1;
                    }
                    else {
                        ballCount += 1;
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        result.add(strikeCount);
        result.add(ballCount);
        return result;
    }
}
