package baseball;

import java.util.List;

public class BaseBallUmpire {
    private static int ball=0;
    private static int strike=0;

    public String umpire(String userAnswer, List<String> computer) {
        ball=0; strike=0;

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

        return shouting();
    }

    private String shouting() {
        StringBuilder sb = new StringBuilder();
        if(ball !=0 && strike !=0){
            sb.append(ball+"볼 "+strike+"스트라이크");
        } else if (ball==0 && strike==0) {
            sb.append("낫싱");
        } else if (strike==0) {
            sb.append(ball+"볼");
        } else if(ball ==0){
            sb.append(strike+"스트라이크");
        }
        String shout = sb.toString();
        System.out.println(shout);
        return shout;
    }
}
