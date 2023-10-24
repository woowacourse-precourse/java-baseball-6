package baseball.game;

import baseball.ball.Baseball;
import baseball.ball.BallBoundary;
import baseball.errors.FindBaseballInputError;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class PlayBaseballGame implements PlayGame{
    private Baseball ball = new Baseball(BallBoundary.MAX_VALUE.getValue(), BallBoundary.MIN_VALUE.getValue());
    private String inputNumber;
    private boolean flag = false;
    PlayBaseballGame() {
        inputNumber = "";
    }
    public void input(){
        System.out.print("숫자를 입력해주세요 : ");
        inputNumber = Console.readLine();
    }
    public List<Integer> countMatch(){
        String gameBall = ball.getNumber();
        int strike = 0, ball = 0;
        for(int i = 0; i < inputNumber.length(); i++){
            if (gameBall.charAt(i) == inputNumber.charAt(i)) {
                strike++;
            }
            else{
                for(int j = 0; j < gameBall.length(); j++){
                    if((inputNumber.charAt(i) == gameBall.charAt(j)) && (i != j)){
                        ball++;
                    }
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        list.add(strike);
        list.add(ball);
        return list;
    }


    public void printResult(int strike_, int ball_){
        int strike = strike_;
        int ball = ball_;
        if(strike == Rule.MATCH_COUNT.getValue()){
            System.out.println(Rule.MATCH_COUNT.getValue() + "스트라이크");
            System.out.println(Rule.MATCH_COUNT.getValue() + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
            flag = true;
        }
        else{
            if((strike != 0) && (ball != 0)){
                System.out.println(ball + "볼 " + strike + "스트라이크");
            }
            else if((strike == 0) && (ball == 0)) System.out.println("낫싱");
            else if(strike == 0){
                System.out.println(ball + "볼");
            }
            else if(ball == 0){
                System.out.println(strike + "스트라이크");
            }
        }
    }

    public boolean getFlag() {
        return flag;
    }

    public String getInputNumber() {
        return inputNumber;
    }

    public void findErrors(){
        FindBaseballInputError findBaseballInputError = new FindBaseballInputError();
        findBaseballInputError.duplicatedNumber(this.getInputNumber());
        findBaseballInputError.matchLength(this.getInputNumber());
        findBaseballInputError.verifyNonChar(this.getInputNumber());
    }
}
