package baseball.model;

import baseball.constant.GameResult;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Computer {
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

    public Map<GameResult, Long> compare(GameNumber userGameNumber){
        long matchCount = gameNumber.containsCount(userGameNumber);
        long strikeCount = gameNumber.matchCount(userGameNumber);
        long ballCount = Math.abs(strikeCount - matchCount);
        if(strikeCount == 0 && ballCount == 0){
            return Map.of(GameResult.NOTHING, matchCount);
        }
        return Map.of(GameResult.STRIKE, strikeCount, GameResult.BALL, ballCount);

    }
}
