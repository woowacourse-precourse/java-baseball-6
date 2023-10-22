package baseball.controller;

import baseball.model.BaseballGame;
import baseball.model.RangeConstant;
import baseball.view.BaseballGameView;

public class BaseballGameController {

    private BaseballGameView baseballGameView;

    public BaseballGameController() {
        baseballGameView = new BaseballGameView();
    }

    public int startGame() {
        int randomNumber = BaseballGame.makeRandomNumber();
        int userInput;
        // 이 예외처리가 catch 하는 것이 아니라 그냥 터뜨리는 것인지 확인 필요?
        // 입력값이 정수가 아닐 경우 예외처리
        try {
            userInput = baseballGameView.readUserInputView();
            isVerified(userInput); // 입력값이 정수이지만 범위에 맞지 않을 경우 예외 던져짐
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return 0;
        }

        // 사용자 입력값 분석해서 볼 스트라이크 확인 메서드
        BaseballGame result = BaseballGame.checkScore(randomNumber, userInput);

        // 확인 결과 반환받고 뷰로 뿌리는 메서드





        return 1;
    }

    public void isVerified(int userInput) {
        if(userInput < RangeConstant.START_INT || RangeConstant.END_INT < userInput) {
            throw new IllegalArgumentException(String.valueOf("For incorrect range: " + userInput));
        }
    }




}
