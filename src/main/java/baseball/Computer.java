package baseball;
import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Computer {
    List<Integer> answer = new ArrayList<>();
    Computer(){ // 정답 생성
        while(answer.size()<3) {
            // 숫자 하나 뽑음
            int com_num = pickNumberInRange(1, 9);
            boolean same_check = true;
            // 현재까지 생성된 숫자랑 중복되는지 체크
            for(int i=0;i<answer.size();i++){
                if(answer.get(i) ==com_num) {
                    same_check = false;
                    break;
                }
            }
            // 중복이 아니라면 정답에 추가
            if(same_check) answer.add(com_num);
        }
    }
    public String check(List<Integer> user_num){
        int ball=0;
        int strike=0;
        String check_result= "";
        //사용자 입력 하나씩 ball,strike 판정
        for(int i=0;i<answer.size();i++){
            for(int j=0;j<user_num.size();j++){
                if(answer.get(i)==user_num.get(j)){
                    if(i==j)strike++;
                    else ball++;
                }
            }
        }
        // ball, strike 갯수대로 출력
        if(ball==0&&strike==0)check_result="낫싱";
        else if(ball==0) check_result=Integer.toString(strike)+"스트라이크";
        else if(strike==0) check_result=Integer.toString(ball)+"볼";
        else check_result = Integer.toString(ball)+"볼 "+Integer.toString(strike)+"스트라이크";
        return check_result;
    }
}
