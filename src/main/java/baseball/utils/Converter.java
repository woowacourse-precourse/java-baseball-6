package baseball.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Converter {
    public static List<Integer> toInteger(String numbers) {
        List<String> playerNumbers = List.of(numbers.split(""));
        return playerNumbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static String toString(Map<String, Integer> result) {
        String BALL = Score.BALL.getNum();
        String STRIKE = Score.STRIKE.getNum();
        Integer ballNum = result.get(Score.BALL.getResult());
        Integer strikeNum = result.get(Score.STRIKE.getResult());
        List<String> answer = new ArrayList<>();

        if(ballNum > 0) {
            answer.add(ballNum + BALL);
        }

        if(strikeNum > 0) {
            answer.add(strikeNum + STRIKE);
        }

        if(answer.size() == 0) {
            return Score.NOTHING.getNum();
        }

        return String.join(" ", answer);
    }
}
