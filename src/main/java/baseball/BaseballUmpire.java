package baseball;

import java.util.List;

public class BaseballUmpire {
    static int ball=0;
    static int strike=0;

    public String umpire(String userAnswer, List<String> computer) {
        ball=0; strike=0;
        StringBuilder sb = new StringBuilder();
        String[] ans = BaseBallGame.userAnswer.split("");

        for(int i =0; i<3;i++){
            if(BaseBallGame.computer.contains(ans[i])){
                if(ans[i].equals(BaseBallGame.computer.get(i))){
                    strike++;
                    continue;
                }
                ball ++;
            }
        }

        if(ball !=0 && strike !=0){
            sb.append(ball+"볼 "+strike+"스트라이크");
        } else if (ball==0 && strike==0) {
            sb.append("낫싱");
        } else if (strike==0) {
            sb.append(ball+"볼");
        } else if(ball ==0){
            sb.append(strike+"스트라이크");
        }

        System.out.println(sb.toString());
        return sb.toString();
    }
}
