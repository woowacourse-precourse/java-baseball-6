package baseball.umpire;

import java.util.List;

public class BaseBallUmpire {
    private static int ball=0;
    private static int strike=0;

    private String[] usersAnswer;

    public void umpire(String userAnswer, List<String> computer) {
        ball=0; strike=0;

        usersAnswer = userAnswer.split("");

        for(int i =0; i<3;i++){
            if(computer.contains(usersAnswer[i])){
                if(usersAnswer[i].equals(computer.get(i))){
                    strike++;
                    continue;
                }
                ball ++;
            }
        }
    }

    public void shouting() {
        if(ball !=0 && strike !=0){
            System.out.println(ball+"볼 "+strike+"스트라이크");
        } else if (ball==0 && strike==0) {
            System.out.println("낫싱");
        } else if (strike==0) {
            System.out.println(ball+"볼");
        } else if(ball ==0){
            System.out.println(strike+"스트라이크");
        }
    }

    public boolean threeStrikeVAR() {
        return (strike==3);
    }

}
