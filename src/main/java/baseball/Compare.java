package baseball;

import java.util.List;
import java.util.Objects;

public class Compare {
    // 동일한 숫자 개수 세기
    public int Hit(List<Integer> computer, List<Integer> player) {
        int result = 0;

        for(int i = 0; i < player.size(); i++) {
            if(computer.contains(player.get(i))) result++;
        }
        return result;
    }

    // 스트라이크 개수 세기
    public int countStrike(List<Integer> computer, List<Integer> player) {
        int strike = 0;

        for(int i = 0; i < player.size(); i++) {
            if(Objects.equals(computer.get(i), player.get(i))) strike++;
        }
        return strike;
    }

    public String classification(List<Integer> computer, List<Integer> player) {
        int total = Hit(computer, player);
        int strike = countStrike(computer, player);
        int ball = total - strike;

        if(total == 0) return "낫싱";
        else if(strike == 0) return ball + "볼";
        else if(ball == 0) return strike + "스트라이크";

        return ball + "볼 " + strike + "스트라이크";
    }
}