package baseball.controller;

import static baseball.model.BaseballGameModel.THREE_STRIKE;
import static baseball.validator.BaseballInputValidator.MENU_EXIT;
import static baseball.validator.BaseballInputValidator.MENU_REPLAY;

import baseball.model.BaseballGameModel;
import baseball.view.BaseballGameView;

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
            String result = baseballGameModel.calculateResult(userInputNums); // 사용자가 입력한 숫자와 정답 숫자를 비교
            if (result.equals(THREE_STRIKE)) { // 사용자가 정답 숫자를 입력했을 시
                baseballGameView.showResult(result); // 3스트라이크라는 문구 출력
                String decide = baseballGameView.replayOrExit(); // 게임 재시작 or 종료
                if (decide.equals(MENU_REPLAY)) { // 1을 입력받을 시 게임 재시작
                    baseballGameModel = new BaseballGameModel(); // 새로운 정답 숫자 생성
                } else if (decide.equals(MENU_EXIT)) { // 2를 입력받을 시 게임 종료
                    break;
                }
            } else {
                baseballGameView.showResult(result);
            }
        }
    }
}

