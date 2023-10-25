package baseball;

import java.util.List;

public class Compare {
    public int countAll(List<Integer> computer, List<Integer> player) {
        int count = 0;
        for(int i = 0; i < player.size(); i++){
            if(computer.contains(player.get(i))){
                count += 1;
            }
        }
        return count;
    }

    public int countBall(List<Integer> computer, List<Integer> player) {
        int ball = 0;
        for(int i = 0; i < player.size(); i++){
            if(computer.contains(player.get(i)) && computer.get(i) != player.get(i)){
                ball += 1;
            }
        }
        return ball;
    }

    public int countStrike(List<Integer> computer, List<Integer> player) {
        int strike = 0;
        for(int i = 0; i < player.size(); i++){
            if(computer.get(i) == player.get(i)){
                strike += 1;
            }
        }
        return strike;
    }
}
