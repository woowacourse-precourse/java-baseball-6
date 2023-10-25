package baseball.domain;

import java.util.List;

public class Judge {
    public String compare(List<Integer> computer, List<Integer> player){
        JudgeNumber judgeNumber = new JudgeNumber();

        int count = judgeNumber.count(computer, player);
        int strike = 0;

        for (int i = 0; i < player.size(); i++) {
            if(judgeNumber.isNumber(computer, i, player.get(i))){
                strike++;
            }
        }
        int ball = count - strike;

        if(count == 0){
            return "낫싱";
        }

        return ball + " 볼 " + strike + " 스트라이크";
    }
}
