package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Baseball<T> {
    protected List<T> values;

    private Baseball() { //생성자 대신 정적 팩터리 메서드 사용

    }

    private Baseball(List<T> values) {
        this.values = values;
    }

    public static <T> Baseball<T> createBaseball(List<T> values) {
        return new Baseball<>(values);
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
