package baseball;

import java.util.List;

public class CountResult {

    private final int ballCount;
    private final int strikeCount;

    public CountResult(List<Integer> computerNumber, List<Integer> playerNumber) {
        this.ballCount = countBall(computerNumber, playerNumber);
        this.strikeCount = countStrike(computerNumber, playerNumber);
    }

    public int countBall(List<Integer> computerNumber, List<Integer> playerNumber){
        int count = 0;
        for(int i=0; i<computerNumber.size(); i++){
            if(!playerNumber.get(i).equals(computerNumber.get(i))
            && computerNumber.contains(playerNumber.get(i))){
                count++;
            }
        }
        return count;
    }

    public int countStrike(List<Integer> computerNumber, List<Integer> playerNumber){
        int count = 0;

        for(int i=0; i<computerNumber.size(); i++){
            if(playerNumber.get(i).equals(computerNumber.get(i))){
                count++;
            }
        }
        return count;
    }

    public String makeHintString(){

        if (ballCount==0 && strikeCount==0){
            return "낫싱";
        }

        StringBuilder stringBuilder = new StringBuilder();
        if(ballCount!=0){
            stringBuilder.append(ballCount).append("볼 ");
        }
        if(strikeCount!=0){
            stringBuilder.append(strikeCount).append("스트라이크");
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
