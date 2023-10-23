package baseball.service;

import baseball.model.NumberFormat;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    /**
     *
     * @return {strike 개수, ball 개수}
     */
    public static List<Integer> compareNumberFormat(NumberFormat answer, NumberFormat input){
        int strikeCount = 0;
        int ballCount = 0;

        List<Integer> inputNumberList = input.getNumberList();
        List<Integer> answerNumberList = answer.getNumberList();

        for (int i = 0; i< inputNumberList.size(); i++) {
            Integer value = inputNumberList.get(i);
            if (value == answerNumberList.get(i)) strikeCount++;
            else if (answerNumberList.contains(value)) ballCount++;
        }

        List<Integer> result = new ArrayList<>();
        result.add(strikeCount);
        result.add(ballCount);

        return result;
    }


}
