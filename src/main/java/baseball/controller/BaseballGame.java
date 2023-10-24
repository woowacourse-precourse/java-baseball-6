package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.model.PlayerNumber;
import baseball.util.ValidatorUtility;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGame {
    private final ComputerNumber computer;
    private static PlayerNumber player;
    private final ValidatorUtility validator;

    public BaseballGame() {
       computer = new ComputerNumber();
       validator = new ValidatorUtility();
    }

    ////////////////////////////

    public void start(){
        do {
            getNumberFromPlayer();
            printCount(getNumberCompare());

        }while (!isGameSet());
    }

    public void getNumberFromPlayer(){
        player = new PlayerNumber(InputView.setPlayerNumber());
         player.getPlayerNumber();
    }
    public int[] getNumberCompare(){
        return validator.getNumberUtility(player.getPlayerNumber(), computer.getComputerNumber());
    }


    //////////////////////////////
    public void printCount(int[] count){
        printBallCount(count);
        printStrikeCount(count);
        printNothing(count);
    }
    public static void printBallCount(int[]count){ //볼메세지
        if (count[0] != 0){
            if (count[1] != 0){ //볼과 스트라이크 존재
                OutputView.printCount(count[0]);
                OutputView.printBallStrikeMessage();
            }
            else{  //볼만존재
                OutputView.printCount(count[0]);
                OutputView.printBallMessage();
            }
        }
    }
    public static void printStrikeCount(int[]count){//스트라이크메세지
        if (count[1] != 0){
            OutputView.printCount(count[1]);
            OutputView.printStrikeMessage();
        }

    }
    public static void printNothing(int[]count){//낫싱메세지
        if (count[0] ==0 && count[1] ==0){
            OutputView.printNothingMessage();
        }
    }
    public boolean isGameSet(){//스리스타라이크!게임종료메세지
        if (validator.ThreeStrike()){
            OutputView.printGameSetMessage();
            return true;
        }
        return false;
    }

}
