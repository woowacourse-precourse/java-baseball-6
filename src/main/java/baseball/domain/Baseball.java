package baseball.domain;

import baseball.util.ExceptionUtil;
import baseball.util.IntegerListUtil;
import baseball.util.IntegerUtil;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Baseball { //TODO: NumberBaseball로 이름 바꾸기

    private Baseball() { //생성자 대신 정적 팩터리 메서드 사용

    private final List values;

    //생성자 대신 정적 팩터리 메서드 사용
    private Baseball(List values) {
        this.values = values;
        IntegerListUtil.validateListType(values);
    }

    public static Baseball createBaseball(String valueString) {
        IntegerUtil.validateInteger(valueString);
        List values = IntegerListUtil.parseIntegerList(valueString);

        return new Baseball(values);
    }

    public static Baseball createBaseball(List values) {
        return new Baseball(values);
    }

    public static Baseball createRandomBaseball() { //정적 팩터리 메서드
        List<Integer> computerList = new ArrayList<>();

        while (computerList.size() < GameConstants.NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(GameConstants.MIN_DIGIT, GameConstants.MAX_DIGIT);
            if (!computerList.contains(randomNumber)) {
                computerList.add(randomNumber);
            }
        }

        return createBaseball(computerList);
    }

    public List<T> getValues() {
        return values;
    }

    public void setValues(List<T> values) {
        this.values = values;
    }



}
