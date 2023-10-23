package baseball.view;

import baseball.constant.GameResult;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    public void printGameBegin(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public void printGameResult(Map<GameResult, Long> result){
        System.out.println(getResultToString(result));
    }
    public void printGameFinish(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private String getResultToString(Map<GameResult, Long> result){
        StringBuilder resultBuilder = new StringBuilder();
        for(Map.Entry<GameResult, Long> entry : result.entrySet()){
            if(entry.getKey().equals(GameResult.NOTHING)){
                return GameResult.NOTHING.getName();
            }
            if(entry.getValue() != 0L){
                resultBuilder.append(entry.getValue());
                resultBuilder.append(entry.getKey().getName());
                resultBuilder.append(" ");
            }
        }
        return resultBuilder.toString().trim();
    }
}
