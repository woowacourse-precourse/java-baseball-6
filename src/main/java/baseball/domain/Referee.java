package baseball.domain;

import baseball.view.ResultView;

public class Referee {
    private ResultView resultView;
    private String result = "";

    public Referee(ResultView resultView) {
        this.resultView = resultView;
    }

    // 게임 지속 여부 확인
    // 결과가 3스트라이크라면 게임 종료
    // 결과가 3스트라이크가 아니라면 게임 지속
    public boolean isOut(String result) {
        if(result.equals("3스트라이크")) {
            resultView.showResult("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }else {
            return false;
        }
    }
}
