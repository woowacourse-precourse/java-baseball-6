package baseball.ui;

import baseball.result.BaseballGameResult;

/**
 * @author 민경수
 * @description game end display
 * @since 2023.10.23
 **********************************************************************************************************************/
public class GameEndDisplay implements PrintResultMessage {

    @Override
    public void print(BaseballGameResult baseballGameResult) {
        System.out.println(baseballGameResult.strikeCount() + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

}