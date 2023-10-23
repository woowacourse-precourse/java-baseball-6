package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.model.UserInputNumber;
import baseball.model.UserRestartNumber;
import baseball.view.OutputView;
import baseball.view.UserInputView;

public class GameController {
    private ComputerNumber computer;
    private UserInputNumber userInput;
    private UserRestartNumber userRestart;
    private int ball;
    private int strike;

    public GameController() {
        computer = new ComputerNumber();
    }

    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void gameEngine() {
        do {
            gamePlay();
            userRestart = new UserRestartNumber(UserInputView.getUserInputRestart());
            computer.setComputerNumber();
        } while (userRestart.getRestartNumber().equals("1"));
    }

    public void gamePlay(){
        do {
            userInput = new UserInputNumber(UserInputView.getUserInputNumber());
            compareComputerNumberAndUserInput(computer.getComputerNumber(), userInput.getUserInputNumber());
            OutputView.printBallStrike(ball,strike);
        } while (strike != 3);
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void compareComputerNumberAndUserInput(String computerNumber, String userInputNumber) {
        ball = 0;
        strike = 0;

        for(int i=0;i<3;i++){
            String nowComNumber = computerNumber.substring(i,i+1);
            for(int j=0; j<3;j++) {
                String nowUserNumber = userInputNumber.substring(j,j+1);
                if(nowUserNumber.equals(nowComNumber)) {
                    if (i == j){
                        strike += 1;
                    }
                    else {
                        ball += 1;
                    }
                }
            }
        }
    }
}
