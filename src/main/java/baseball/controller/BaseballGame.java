package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.model.PlayerNumber;
import baseball.model.ReplayNumber;
import baseball.util.Validator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGame {
    private final ComputerNumber computerNumber;
    private static PlayerNumber playerNumber;
    private final Validator validator;

    private static final int BALL = 0;
    private static final int STRIKE = 1;


    public BaseballGame(){
        computerNumber = new ComputerNumber();
        validator = new Validator();
    }

    public void start(){
        do{
            getNumberFromPlayer();
            printCount(getNumberCompare());
        } while(!isGameSet());
    }

    public void getNumberFromPlayer(){
        playerNumber = new PlayerNumber(InputView.setUserNumber());
        playerNumber.getPlayerNumber();
    }

    public int[] getNumberCompare() {
        return validator.getNumberCompare(playerNumber.getPlayerNumber(), computerNumber.getComputerNumber());
    }

    public void printCount(int[] count){
        printBallCount(count);
        printStrikeCount(count);
        printNothing(count);
    }

    public static void printBallCount(int[] count){
        if(count[BALL] != 0){
            if(count[STRIKE] !=0){
                OutputView.printCount(count[BALL]);
                OutputView.printBallAndStrikeMessage();
            }else{
                OutputView.printCount(count[BALL]);
                OutputView.printBallMessage();
            }
        }
    }

    public static void printStrikeCount(int[] count){
        if(count[STRIKE] != 0){
            OutputView.printCount(count[STRIKE]);
            OutputView.printStrikeMessage();
        }
    }

    public static void printNothing(int[] count){
        if(count[BALL]==0 && count[STRIKE]==0){
            OutputView.printNothingMessage();
        }
    }

    public boolean isGameSet(){
        if(validator.isThreeStrike()){
            OutputView.printGamesetMessage();
            return true;
        }
        return false;
    }

    public static boolean askReplay(){
        ReplayNumber replayNumber = new ReplayNumber(InputView.setReplayNumber());

        if(replayNumber.getReplayNumber().equals("1")){
            return true;
        }
        return false;
    }
}
