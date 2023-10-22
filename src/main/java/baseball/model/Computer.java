package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Computer {
    private final String STRIKE = "스트라이크";
    private final String BALL = "볼";
    private final String NOTHING = "낫싱";
    private GameNumber gameNumber;

    public Computer(List<Integer> numbers){
        gameNumber = new GameNumber(numbers);
    }

    public static List<Integer> createNumbers(){
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    public Map<String, Long> calculate(GameNumber userGameNumber){
        long matchCount = gameNumber.containsCount(userGameNumber);
        long strikeCount = gameNumber.matchCount(userGameNumber);
        long ballCount = Math.abs(strikeCount - matchCount);
        if(strikeCount == 0 && ballCount == 0){
            return Map.of(NOTHING,0L);
        }
        return Map.of(STRIKE, strikeCount, BALL, ballCount);

    }
}
