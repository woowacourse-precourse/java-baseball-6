package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.model.UserNumber;
import baseball.view.InputView;
import baseball.view.OutputView;


public class NumberBaseballGameController {

    private static UserNumber userNumber ;
    private static OutputView outputView = new OutputView();
    private  static ComputerNumber computerNumber;
    private static CompareController comparecontroller = new CompareController();
    private int[] score = new int[2];
    private int length = 3;
    public void startGame(){
        outputView.gameStart();
        computerNumber = new ComputerNumber();
        System.out.println("computerNumber = " + computerNumber.getComputerNumber());
        do{
            getUserNumber();
            hintPrint(comparecontroller.gameResult(computerNumber.getComputerNumber(), userNumber.getUserNumber()));

        }while(!gameEnd());
    }
    public void getUserNumber(){
        userNumber = new UserNumber(InputView.inputNumber());
    }

    public void hintPrint(int[] score){
        if(score[0]==0 && score[1]==0){
            outputView.nothingMessage();
        }
        else{
            if(score[0]!=0){
                if(score[1]!=0) {
                    outputView.ballStrikeMessage(score[0]);
                }
                else{
                    outputView.ballMessage(score[0]);
                }

            }
            if(score[1]!=0){
                outputView.strikeMessage(score[1]);
            }
        }
        this.score = score;

    }

    public boolean gameEnd(){
        if(score[1]==length){
            outputView.gameEnd();
            return true;
        }
        return false;
    }
}
