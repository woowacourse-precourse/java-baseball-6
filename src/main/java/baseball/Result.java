package baseball;

public class Result{

    private int ball;

    private int strike;


    public Result(int ball, int strike){
        this.ball = ball;
        this.strike = strike;
    }

    public void printResult(){
        String result = printIfNothing() + printIfBall() + printIfStrike();
        System.out.println(result);
    }

    private String printIfNothing(){
        if (this.ball == 0 && this.strike == 0){
            return "낫싱";
        }
        return "";
    }

    private String printIfBall(){
        if (this.ball != 0){
            return this.ball + "볼 ";
        }
        return "";
    }

    private String printIfStrike(){
        if (this.strike != 0){
            return this.strike + "스트라이크";
        }
        return "";
    }

    public boolean isAllStrike(){
        return this.strike == 3;
    }

}
