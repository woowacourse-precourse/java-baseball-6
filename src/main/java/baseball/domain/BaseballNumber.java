package baseball.domain;

import baseball.util.Util;
import java.util.List;

//숫자 야구 게임의 컴퓨터의 사용자의 수를 위한 클래스
public class BaseballNumber {
    private List<Integer> number;

    public BaseballNumber(String number) {
        validateInputString(number);
        this.number = Util.stringToIntegerList(number);
    }

    public BaseballNumber(List<Integer> computerNumber) {
        this.number = computerNumber;
    }

    @Override
    public String toString() {
        return "BaseballNumber{" +
                "number=" + number +
                '}';
    }

    private static void validateInputString(String input) {
        Util.validateStringLength(3, input, "입력의 길이는 3이어야합니다.");
        Util.validateStringIsNaturalNumber(input, "자연수로만 입력되어야합니다.");
        Util.validateStringHasNot("0", input, "입력은 0을 포함할 수 없습니다.");
        Util.validateStringAllDifferent(input, "모든 입력된 값은 달라야합니다.");
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
