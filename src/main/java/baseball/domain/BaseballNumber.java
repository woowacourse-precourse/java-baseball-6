package baseball.domain;

import baseball.util.Util;
import java.util.List;

//숫자 야구 게임의 컴퓨터의 사용자의 수를 위한 클래스
public class BaseballNumber {
    private List<Integer> number;

    public BaseballNumber(String number) {
        this.number = Util.stringToIntegerList(number);
    }

    public BaseballNumber(List<Integer> computerNumber) {
        this.number = computerNumber;
    }

    public static BaseballScore compareNumber(BaseballNumber computerNumber, BaseballNumber userNumber) {
        BaseballScore baseballScore = new BaseballScore(0, 0);
        List<Integer> computerNumberList = computerNumber.number;
        List<Integer> userNumberList = userNumber.number;
        baseballScore.addStrikeCount(Util.countSameValueSameIdxByIntegerList(computerNumberList, userNumberList));
        baseballScore.addBallCount(Util.countSameValueDifferentIdxByList(computerNumberList, userNumberList));
        return baseballScore;
    }
}
