package baseball.refree;

import java.util.List;

public class Refree {
    public String count(List<Integer> computer, List<Integer> player) {
        int strike = 0;
        int ball = 0;
        String result = "";

        for(int i = 0; i < player.size(); i++){
            for(int j = 0; j < computer.size(); j++){
                if(player.get(i) == computer.get(j)){
                    if(i == j) {
                        strike += 1;
                    } else {
                        ball += 1;
                    }
                }
            }
        }

        if(ball != 0){
            result += ball + "볼 ";
        }
        if(strike != 0){
            result += strike + "스트라이크";
        }
        if(ball == 0 && strike == 0){
            result += "낫싱";
        }

        return result;
    }
}