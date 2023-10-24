package baseball.domain;

import java.util.List;
import java.util.stream.IntStream;

public class GameResult {

    public int ballCount;
    public int strikeCount;
    private final int listLength = 3;

    public GameResult(List<Integer> computerNumber, List<Integer> userInputNumber) {
        this.ballCount = ballPointCount(computerNumber, userInputNumber);
        this.strikeCount = strikePointCount(computerNumber, userInputNumber);
    }
    private int ballPointCount(List<Integer> computerNumber, List<Integer> userInputNumber){
        for (int i = 0; i < computerNumber.size(); i++) {
            if ((userInputNumber.get(i)!=computerNumber.get(i))&&computerNumber.contains(userInputNumber.get(i)))
                ballCount++;
        }
        return ballCount;
    }
    private int strikePointCount(List<Integer> computerNumber, List<Integer> userInputNumber){
        for (int i = 0; i < computerNumber.size(); i++) {
            if(computerNumber.get(i) == userInputNumber.get(i)){
                strikeCount++;
            }
        }
        return strikeCount;
    }
}
