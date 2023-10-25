package baseball.Controller;

import baseball.Model.BaseballGameModel;
import baseball.View.BaseballGameView;

public class BaseballGameController {
    private BaseballGameModel baseballGameModel;
    private BaseballGameView baseballGameView;

    public BaseballGameController(BaseballGameModel baseballGameModel, BaseballGameView baseballGameView) {
        this.baseballGameModel = baseballGameModel;
        this.baseballGameView = baseballGameView;
    }

    public void play() { // 0. 게임을 실행하는 메서드
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            String[] userInputNums = baseballGameView.inputThreeNums(); // 사용자에게 숫자를 입력받는다
            String result = baseballGameModel.calculateResult(userInputNums,
                    baseballGameModel.getAnswerNums()); // 사용자가 입력한 숫자와 정답 숫자를 비교
            if (result == "3스트라이크") {
                baseballGameView.showResult(result);
                String decide = baseballGameView.replayOrExit();
                if (decide.equals("1")) { // 1을 입력받을 시 게임 재시작
                    
                } else if (decide.equals("2")) {
                    break;
                }
            } else {
                baseballGameView.showResult(result);
            }
        }
    }
}

