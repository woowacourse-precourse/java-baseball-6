package baseball.domain;

import baseball.util.Util;
import java.util.List;

/*
 * 숫자야구게임 중 스트라이크와 볼 개수 관리하는 클래스
 * */

public class BaseballNumber {
    private List<Integer> number;

    public BaseballNumber(String number) {
        this.number = Util.naturalNumberstringToIntegerList(number);
    }

    public BaseballNumber(List<Integer> computerNumber) {
        this.number = computerNumber;
    }

    public static BaseballScore compareNumber(BaseballNumber computerNumber, BaseballNumber userNumber) {
        BaseballScore baseballScore = new BaseballScore();
        List<Integer> computerNumberList = computerNumber.number;
        List<Integer> userNumberList = userNumber.number;
        baseballScore.addStrikeCount(Util.countSameValueSameIdxByIntegerLists(computerNumberList, userNumberList));
        baseballScore.addBallCount(Util.countSameValueDifferentIdxByIntegerLists(computerNumberList, userNumberList));
        return baseballScore;
    }
}
