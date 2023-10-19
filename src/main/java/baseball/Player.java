package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Player {
    private ArrayList<Integer> playerValue;
    private final DataValidator dataValidator;
    private int strike;
    private int ball;

    public Player() {
        this.playerValue = new ArrayList<Integer>();
        this.dataValidator = new DataValidator();
        strike = 0;
        ball = 0;
        continueDecision = 1;
    }

    public void setPlayerValue() {
        System.out.print("숫자를 입력해주세요 : ");
        String[] stringValue  = Console.readLine().split("");
        for(String s : stringValue){
            playerValue.add(Integer.parseInt(s));
        }
        dataValidator.playerValueValidation(playerValue);
    }

    public ArrayList<Integer> getPlayerValue(){
        return playerValue;
    }

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public int getContinueDecision() {
        return continueDecision;
    }

    public void setContinueDecision(int continueDecision) {
        this.continueDecision = continueDecision;
    }

    private int continueDecision;




}
