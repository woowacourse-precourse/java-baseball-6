package baseball;

import java.util.List;

public class RuleManager {
    private final static int LENGTH=3;
    private int strikeCnt;
    private int ballCnt;
    
    RuleManager(){
        this.strikeCnt=0;
        this.ballCnt=0;
    }

    public void compareNumber(Computer computer, User user){
        int strike=0;
        int ball=0;
        List<Integer> computerNum=computer.getNumber();
        List<Integer> userNum=user.getNumber();
        for(int i=0;i<LENGTH;i++){
            if(computerNum.get(i)==userNum.get(i))
                strike++;
            if(computerNum.get(i)==userNum.get((i+1)%LENGTH))
                ball++;
            if(computerNum.get(i)==userNum.get((i+2)%LENGTH))
                ball++;    
        }
        strikeCnt=strike;
        ballCnt=ball;
    }

    public void printStrikeAndBallCnt(){
        if(ballCnt==0 && strikeCnt==0)
            System.out.print("낫싱");
        if(ballCnt>0)
            System.out.print(ballCnt+"볼"+" ");
        if(strikeCnt>0)
            System.out.print(strikeCnt+"스트라이크");
        System.out.println();
    }

    public boolean isAnswer(){
        if(strikeCnt==3)
            return true;
        return false;
    }

}
