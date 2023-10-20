package baseball.domain;

import java.util.List;

public class Result {

    public static final String STRIKE_MESSAGE ="%d스트라이크";
    public static final String BALL_MESSAGE ="%d볼 ";
    public static final String NOTHING_MESSAGE = "낫싱";
    private int strikeCount;
    private int ballCount;

    public Result(List<Integer> computerNumbers,List<Integer> inputInteger){
        calculateResult(computerNumbers,inputInteger);
    }

    private void calculateResult(List<Integer> computerNumbers,List<Integer> inputInteger){
        for (int number : inputInteger){
            if(computerNumbers.contains(number)){
                this.ballCount++;
            }
            if(computerNumbers.indexOf(number) == inputInteger.indexOf(number)){
                this.ballCount--;
                this.strikeCount++;
            }
        }
    }

    public String resultToString(){
        if(ballCount == 0 && strikeCount == 0) {
            return NOTHING_MESSAGE;
        } else if (ballCount == 0) {
            return String.format(STRIKE_MESSAGE,strikeCount);
        } else if (strikeCount == 0) {
            return String.format(BALL_MESSAGE,ballCount);
        }
        return String.format(BALL_MESSAGE+STRIKE_MESSAGE,ballCount,strikeCount);
    }
    public int getStrikeCount(){

        return this.strikeCount;
    }

}
