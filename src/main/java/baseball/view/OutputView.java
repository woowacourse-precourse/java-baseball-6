package baseball.view;

import baseball.domain.BaseballResult;

public class OutputView {
    public void printGameStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printGameResult(BaseballResult baseballResult){
        System.out.println(baseballResult.toString());
    }
}