package baseball;
import java.util.List;

public class Compare {
    public int compareBall(List<Integer> computer, List<Integer> player) {
        int ball = 0;
        for(int i = 0; i < player.size(); i++) {
            if(computer.contains(player.get(i)))
                ball++;
        }
        return ball;
    }
    public int compareStrike(List<Integer> computer, List<Integer> player) {
        int strike = 0;
        for ( int i = 0; i < player.size(); i++) {
            if(computer.get(i).equals(player.get(i)))
                strike++;
        }
        return strike;
    }
}