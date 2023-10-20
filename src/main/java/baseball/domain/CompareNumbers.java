package baseball.domain;
import java.util.*;
public class CompareNumbers {
    private List<Integer> computer;
    private List<Integer> player;
    public CompareNumbers(List<Integer> computer, List<Integer> player){
        this.computer = computer;
        this.player = player;
    }
    public int getTotalHits(){
        int count = 0;
        for(int num : player){
            if(computer.contains(num)) count++;
        }
        return count;
    }
    public int strikeCount(){
        int count = 0;
        for(int i = 0; i < 3; i++) {
            if(computer.get(i) == player.get(i)) count++;
        }
        return count;
    }
    public String generateResult(){
        int totalHits = getTotalHits();
        int strike = strikeCount();
        int ball = totalHits - strike;

        if(totalHits == 0) return "낫싱";
        if(strike == 0) return ball + "볼";
        if(ball == 0) return strike + "스트라이크";
        return ball+"볼 "+ strike +"스트라이크";
    }
}
