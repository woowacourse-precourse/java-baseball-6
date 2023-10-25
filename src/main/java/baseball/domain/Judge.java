package baseball.domain;

import java.util.List;

public class Judge {
    public String compare(List<Integer> computer, List<Integer> player){
        JudgeNumber judgeNumber = new JudgeNumber();
        int ballCount = judgeNumber.count(computer, computer);
        int strike = 0;

        for (int i = 0; i < player.size(); i++) {
            if(judgeNumber.isNumber(computer, i, player.get(i))){
                strike++;
            }
        }
        int ball = ballCount - strike;

        return ball + " ball " + strike + " strike";
    }
}
