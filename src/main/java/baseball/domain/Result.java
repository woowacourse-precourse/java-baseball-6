package baseball.domain;

public class Result {
    private int strike;
    private int ball;

    public Result(Numbers computer,Numbers user){
        initialize();

        for(String number:user.splitNumbers()){
            compareIndex(computer.index(number),user.index(number));
        }
    }

    private void initialize(){
        strike=0;
        ball=0;
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

    public boolean equals(Result result){
        return strike == result.strike && ball == result.ball;
    }

    public boolean isNothing(){
        return strike==0 && ball==0;
    }

    public String getResult(){
        if (isNothing()){
            return "낫싱";
        }
        if (ball==0){
            return strike+"스트라이크";
        }
        if (strike==0){
            return ball+"볼";
        }
        return ball+"볼 "+strike+"스트라이크";
    }

    public boolean isThreeStrike(){
        return strike==3;
    }
}