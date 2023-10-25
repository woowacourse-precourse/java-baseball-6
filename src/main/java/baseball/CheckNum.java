package baseball;

import java.util.ArrayList;
import java.util.List;

public class CheckNum {
    List<Integer> answer;
    public CheckNum(List<Integer> computer_num){
        answer = new ArrayList<>(computer_num);
    }
    public int Hit(List<Integer> player){
        int hit=0;
        for(int i=0; i<player.size();i++){
            if(answer.contains(player.get(i)))
                hit++;
        }
        return hit;
    }
    public int Strike(List<Integer> player){
        int strike=0;
        for(int i=0; i<player.size(); i++){
            if(answer.get(i) == player.get(i))
                strike++;
        }
        return strike;
    }
    public String Checknum(List<Integer>player){
        int hit = Hit(player);
        int strike = Strike(player);
        int ball = hit - strike;

        if(hit==0)
            return "낫싱";
        else if(strike ==0)
            return ball+"볼";
        else if(ball==0)
            return strike+"스트라이크";

        return ball+"볼 "+strike+"스트라이크";
    }

}
