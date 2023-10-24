package baseball.domain;

import baseball.view.InputView;
import baseball.view.ResultView;

import java.util.List;

public class Referee {

    public BallCount call(List<Integer> answers, List<Integer> pickNumbers) {
        CheckMachine checkMachine = new CheckMachine(new BallCount(0, 0));
        return checkMachine.checkAnswer(answers, pickNumbers);
    }
    // 게임 지속 여부 확인
    // 결과가 3스트라이크라면 게임 종료
    // 결과가 3스트라이크가 아니라면 게임 지속
//    public boolean isOut(String result) {
//        if(result.equals("3스트라이크")) {
//            resultView.showResult("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
//            return true;
//        }else {
//            return false;
//        }
//    }
//
//    public boolean isAllStrike(BallCount ballCount) {
//        return ;
//    }
}
