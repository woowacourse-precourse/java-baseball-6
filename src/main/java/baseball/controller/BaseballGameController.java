package baseball.controller;

import baseball.model.BaseballGame;
import baseball.model.RangeConstant;
import baseball.view.BaseballGameView;

public class BaseballGameController {

    private BaseballGame baseballGame;
    private BaseballGameView baseballGameView;

    public BaseballGameController() {
        baseballGame = new BaseballGame();
        baseballGameView = new BaseballGameView();
    }

    public int startGame() {
        int randomNumber = baseballGame.makeRandomNumber();
        int userInput;
        baseballGameView.startView();

        // 입력값이 정수가 아닐 경우 예외처리
        try {
            userInput = baseballGameView.readUserInputView();
            isVerified(userInput); // 입력값이 정수이지만 범위에 맞지 않을 경우 예외 던져짐
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return 0;
        }



        return 1;
    }

    public void isVerified(int userInput) {
        if(userInput < RangeConstant.START_INT || RangeConstant.END_INT < userInput) {
            throw new IllegalArgumentException(String.valueOf("For incorrect range: " + userInput));
        }
    }




}
