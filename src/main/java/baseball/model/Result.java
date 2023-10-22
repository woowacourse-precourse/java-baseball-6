package baseball.model;

import baseball.vo.Numbers;

public class Result {
    private int strike;
    private int ball;

    public Result(Numbers computer, Numbers user){
        strike=0;
        ball=0;

        for(String number:user.splitNumbers()){
            compareIndex(computer.index(number),user.index(number));
        }
    }

    private void compareIndex(int computerIndex,int userIndex){
        if(computerIndex==userIndex){
            strike+=1;
            return;
        }

        if(computerIndex!=-1) {
            ball += 1;
        }
    }

    public String getResult(){
        String resultMessage="";

        if(ball!=0){
            resultMessage+=ball+"볼 ";
        }
        if (strike!=0){
            resultMessage+= strike+"스트라이크";
        }
        if (resultMessage.equals("")){
             resultMessage="낫싱";
        }
        return resultMessage.strip();
    }

    public boolean isThreeStrike(){
        return strike==3;
    }
}