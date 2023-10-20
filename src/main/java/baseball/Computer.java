package baseball;
import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Computer {
    List<Integer> answer = new ArrayList<>();
    Computer(){
        while(answer.size()<3) {
            int com_num = pickNumberInRange(1, 9);
            boolean same_check = true;
            for(int i=0;i<answer.size();i++){
                if(answer.get(i) ==com_num) {
                    same_check = false;
                    break;
                }
            }
            if(same_check) answer.add(com_num);
        }
    }
    public String check(List<Integer> user_num){
        int ball=0;
        int strike=0;
        String check_result= "";
        for(int i=0;i<answer.size();i++){
            for(int j=0;j<user_num.size();j++){
                if(answer.get(i)==user_num.get(j)){
                    if(i==j)strike++;
                    else ball++;
                }
            }
        }
        if(ball==0&&strike==0)check_result="낫싱";
        else if(ball==0) check_result=Integer.toString(strike)+"스트라이크";
        else if(strike==0) check_result=Integer.toString(ball)+"볼";
        else check_result = Integer.toString(ball)+"볼 "+Integer.toString(strike)+"스트라이크";
        return check_result;
    }
}
