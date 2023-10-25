package baseball.my_func;

import baseball.my_sol.Num;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumConvertor {
    public static List<Num> mapToBalls(List<Integer> ballMap) {
        NumCheck.isValidBalls(ballMap);
        return IntStream.range(0, 3)
                .mapToObj(index -> new Num(index + 1, ballMap.get(index)))
                .collect(Collectors.toList());
    }

    public static List<Integer> mapToInt(String userInput) {
        return IntStream.range(0, userInput.length())
                .map(index -> charToInt(userInput.charAt(index)))
                .boxed()
                .collect(Collectors.toList());
    }

    private static int charToInt(char ballNo) {
        NumCheck.isValidBallNo(ballNo);
        return ballNo - '0';
    }
}
