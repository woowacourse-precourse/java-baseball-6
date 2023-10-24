package baseball;

import java.util.List;

public class Check {
    public int Hit(List<Integer> computer, List<Integer> player) {
        int result = 0;

        for(int i = 0; i < player.size(); i++) {
            if(computer.contains(player.get(i))) result++;
        }
        return result;
    }

    public int Strike(List<Integer> computer, List<Integer> player) {
        int strike = 0;

        for(int i = 0; i < player.size(); i++) {
            if(computer.get(i) == player.get(i)) strike++;
        }
        return strike;
    }

    public String Classification(List<Integer> computer, List<Integer> player) {
        int hit = Hit(computer, player);
        int strike = Strike(computer, player);
        int ball = hit - strike;

        if(hit == 0) return "낫싱";
        else if(ball == 0) return strike + "스트라이크";
        else if(strike == 0) return ball + "볼";

        return ball + "볼 " + strike + "스트라이크";
    }
}
