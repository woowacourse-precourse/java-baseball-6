package baseball.controller;

import baseball.model.BaseballGame;
import baseball.model.RangeConstant;
import baseball.view.BaseballGameView;

public class BaseballGameController {

    private BaseballGameView baseballGameView;

    public BaseballGameController() {
        baseballGameView = new BaseballGameView();
    }

    public boolean startGame() {
        int randomNumber = BaseballGame.makeRandomNumber();
        int userInput;
        boolean isAnswer = false;
        // 이 예외처리가 catch 하는 것이 아니라 그냥 터뜨리는 것인지 확인 필요?
        // 입력값이 정수가 아닐 경우 예외처리

        while(!isAnswer) {
            try {
                userInput = baseballGameView.readUserInputView();
                isVerified(userInput); // 입력값이 정수이지만 범위에 맞지 않을 경우 예외 던져짐
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return false;
            }

            // 사용자 입력값 분석해서 볼 스트라이크 확인 메서드
            BaseballGame result = BaseballGame.checkScore(randomNumber, userInput);

            // 확인 결과 반환받고 뷰로 뿌리는 메서드
            isAnswer = baseballGameView.showResult(result);
        }

        // 정답을 모두 맞추었으므로 재시작 여부 입력받음
        return baseballGameView.showRestart(); // 재시작이라면 1반환, 종료라면 2반환
    }

    public void isVerified(int userInput) {
        if(userInput < RangeConstant.START_INT || RangeConstant.END_INT < userInput) {
            throw new IllegalArgumentException(String.valueOf("For incorrect range: " + userInput));
        }
    }




}
