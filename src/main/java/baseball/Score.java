package baseball;

import java.util.List;

public class Score {
    public static int calculation(List<Integer> userBalls, List<Integer>computerBalls){

        int score = 0;
        int strike = 0;
        int ball = 0;

        for(int i=0; i<computerBalls.size(); i++){
            for(int j=0; j<userBalls.size(); j++){
                if(computerBalls.get(i) == userBalls.get(j) && i==j){
                    strike +=1;
                    score +=1;
                }else if (computerBalls.get(i) == userBalls.get(j)){
                    ball +=1;
                    score +=1;
                }
            }
        }

        if(strike != 0){
            strikeScore(strike, score);
        }

        if(strike ==0 && ball != 0){
            ballScore(ball);
        }

        if(score == 0) {
            noScore();
        }
        return strike;
    }
    public static void strikeScore(int strike, int score){
        if(score - strike == 0){
            System.out.println(strike+"스트라이크");
        }
        else{
            System.out.println((score-strike) + "볼 " + strike +"스트라이크");
        }
    }

    public static void ballScore(int ball){
        System.out.println(ball+"볼");
    }

    public static void noScore(){
        System.out.println("낫싱");
    }



}
