package baseball;

import java.util.List;
import java.util.stream.Stream;

public class CountResult {
    private final static String NOTHING_SENTENCE = "낫싱";
    private final static String BALL_SENTENCE = "볼";
    private final static String STRIKE_SENTENCE = "스트라이크";

    private final int ballCount;
    private final int strikeCount;

    public CountResult(List<Integer> computerNumber, List<Integer> playerNumber) {
        this.ballCount = countBall(computerNumber, playerNumber);
        this.strikeCount = countStrike(computerNumber, playerNumber);
    }

    public int countBall(List<Integer> computerNumber, List<Integer> playerNumber){

        return (int)Stream.iterate(0, i->i+1).limit(computerNumber.size())
                .filter(i->!playerNumber.get(i).equals(computerNumber.get(i))
                        && computerNumber.contains(playerNumber.get(i)))
                .count();
    }

    public int countStrike(List<Integer> computerNumber, List<Integer> playerNumber){

        return (int)Stream.iterate(0, i->i+1).limit(computerNumber.size())
                .filter(i->playerNumber.get(i).equals(computerNumber.get(i)))
                .count();
    }

    public String makeHintString(){

        if (ballCount==0 && strikeCount==0){
            return NOTHING_SENTENCE;
        }

        StringBuilder stringBuilder = new StringBuilder();
        if(ballCount!=0){
            stringBuilder.append(ballCount).append(BALL_SENTENCE).append(" ");
        }
        if(strikeCount!=0){
            stringBuilder.append(strikeCount).append(STRIKE_SENTENCE);
        }
        return stringBuilder.toString();
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }
}
