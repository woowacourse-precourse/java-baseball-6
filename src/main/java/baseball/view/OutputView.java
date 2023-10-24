package baseball.view;

import baseball.constant.GameResult;
import java.util.Map;

public class OutputView {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_FINISH_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final Long ZERO = 0L;
    private static final String BLANK = " ";

    public void printGameStart() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printGameResult(Map<GameResult, Long> result) {
        System.out.println(convertResultToString(result));
    }

    public void printGameFinish() {
        System.out.println(GAME_FINISH_MESSAGE);
    }

    private String convertResultToString(Map<GameResult, Long> result) {
        if(result.containsKey(GameResult.NOTHING)){
            return GameResult.NOTHING.getKorean();
        }
        String convertedResult = attach(GameResult.BALL, result.get(GameResult.BALL))
                + attach(GameResult.STRIKE, result.get(GameResult.STRIKE));
        return convertedResult.trim();
    }

    private String attach(GameResult gameResult, Long count){
        if(count != ZERO){
            return count + gameResult.getKorean() + BLANK;
        }
        return BLANK;
    }

}
