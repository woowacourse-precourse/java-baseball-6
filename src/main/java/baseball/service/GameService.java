package baseball.service;

import baseball.model.NumberFormat;
import java.util.List;
import java.util.stream.IntStream;

public class GameService {

    /**
     *
     * @return {strike 개수, ball 개수}
     */
    public static List<Integer> compareNumberFormat(NumberFormat answer, NumberFormat input){
        List<Integer> inputNumberList = input.getNumberList();
        List<Integer> answerNumberList = answer.getNumberList();

        int strikeCount = getStrikeCount(inputNumberList, answerNumberList);
        int ballCount = getBallCount(inputNumberList, answerNumberList);

        return List.of(strikeCount, ballCount);
    }

    private static int getBallCount(List<Integer> inputNumberList, List<Integer> answerNumberList) {
        return (int) IntStream.range(0, inputNumberList.size())
                .filter(i -> answerNumberList.contains(inputNumberList.get(i)))
                .filter(i -> !inputNumberList.get(i).equals(answerNumberList.get(i)))
                .count();
    }

    private static int getStrikeCount(List<Integer> inputNumberList, List<Integer> answerNumberList) {
        return (int) IntStream.range(0, inputNumberList.size())
                .filter(i -> inputNumberList.get(i).equals(answerNumberList.get(i)))
                .count();
    }
}
