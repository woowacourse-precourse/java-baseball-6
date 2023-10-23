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
            if (checkStrike(value, answerNumberList, i)) strikeCount++;
            else if (checkBall(answerNumberList, value)) ballCount++;
        }

        List<Integer> result = new ArrayList<>();
        result.add(strikeCount);
        result.add(ballCount);

        return result;
    }

    private static boolean checkStrike(Integer value, List<Integer> answerNumberList, int i) {
        return value == answerNumberList.get(i);
    }

    private static boolean checkBall(List<Integer> answerNumberList, Integer value) {
        return answerNumberList.contains(value);
    }


}
