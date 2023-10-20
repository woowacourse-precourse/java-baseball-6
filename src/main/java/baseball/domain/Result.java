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
        return strike== result.strike && ball== result.ball;
    }
}