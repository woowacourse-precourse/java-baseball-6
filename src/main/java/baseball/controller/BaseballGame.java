package baseball.controller;

import baseball.model.PlayerNumber;
import baseball.model.generateRandom;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGame {
    private final generateRandom computer;
    private static PlayerNumber player;
    private final Judgement judgement;

    public BaseballGame(){
        computer = new generateRandom();
        judgement = new Judgement();
    }

    public void start(){
        do{
            getNumberFromPlayer();
            AlertCount(getCompareNumber());
        }while(!isGameSuccess());
    }

    public void getNumberFromPlayer(){
        player = new PlayerNumber((InputView.userNum()));
        player.getPlayerNum();
    }

    public int[] getCompareNumber(){
        return judgement.getCompareNumber(player.getPlayerNum(), computer.getComputerNum());
    }

    public void AlertCount(int[] count){
        AlertBallCount(count);
        AlertStrikeCount(count);
        AlertNothing(count);
    }

    public static void AlertBallCount(int[] count) {
        if (count[0] != 0) {
            if(count[1] !=0){
                OutputView.AlertCount(count[0]);
                OutputView.AlertballStrike();
            }else{
                OutputView.AlertCount(count[0]);
                OutputView.Alertball();
            }

        }
    }

    public static void AlertStrikeCount(int[] count) {
        if (count[1] != 0) {
            OutputView.AlertCount(count[1]);
            OutputView.AlertStrike();
        }
    }

    public static void AlertNothing(int[] count) {
        if (count[0] == 0 && count[1] == 0) {
            OutputView.AlertNothing();
        }
    }


    public boolean isGameSuccess() {
        if (judgement.isSuccess()) {
            OutputView.AlertSuccess();
            return true;
        }
        return false;
    }
}
