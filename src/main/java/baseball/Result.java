package baseball;

import java.util.List;

public class Result {
    private static final String NOT_THING = "낫싱";
    private static final String BALL = "%d볼 ";
    private static final String STRIKE = "%d스트라이크";

    private int strike;
    private int ball;

    public Result(){
        this.strike = 0;
        this.ball = 0;
    }

    public int resultGame(List<Integer> computer, List<Integer> player){
        countResult(computer, player);
        printResult();
        System.out.println();

        return strike;
    }

    public void printResult(){
        if (this.ball > 0){
            System.out.printf(BALL, ball);
        }
        if (this.strike > 0){
            System.out.printf(STRIKE, strike);
        }
        if (this.ball == 0 && this.strike == 0){
            System.out.print(NOT_THING);
        }
    }

    public void countResult(List<Integer> computer, List<Integer> player){
        for (int i = 0; i < 3; i++){
            if (computer.get(i) == player.get(i)){
                strike++;
            }
            else if (computer.contains(player.get(i))){
                ball++;
            }
        }
    }


}
