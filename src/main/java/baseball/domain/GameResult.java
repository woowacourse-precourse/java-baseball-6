package baseball.domain;

import java.util.List;

public class GameResult {
    public int ballCount;
    public int strikeCount;
    public GameResult(List<Integer> computerNumber, List<Integer> userInputNumber) {
        this.ballCount = ballPointCount(computerNumber, userInputNumber);
        this.strikeCount = strikePointCount(computerNumber, userInputNumber);
    }
    private int ballPointCount(List<Integer> computerNumber, List<Integer> userInputNumber){
            for (int i = 0; i < computerNumber.size(); i++) {
                        if (!(userInputNumber.get(i).equals(computerNumber.get(i)))&&computerNumber.contains(userInputNumber.get(i))) {
                                ballCount++;
                        }
            }
            return ballCount;
    }
    private int strikePointCount(List<Integer> computerNumber, List<Integer> userInputNumber){
            for (int i = 0; i < computerNumber.size(); i++) {
                        if(computerNumber.get(i).equals(userInputNumber.get(i))){
                            strikeCount++;
                        }
            }
            return strikeCount;
    }
}
