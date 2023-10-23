package baseball.model;

import static baseball.utils.BaseballConstantUtils.BASEBALL_NUMBERS_LENGTH;
import static baseball.utils.BaseballConstantUtils.MAX_BASEBALL_NUMBER;
import static baseball.utils.BaseballConstantUtils.MIN_BASEBALL_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * BaseballNumbers 객체를 생성해주는 클래스
 */

public class BaseballNumbersGenerator {

    /**
     * 숫자 야구 게임의 정답지 역할인 computerBaseballNumbers를 생성하는 메서드
     *
     * @return 랜덤 값으로 만들어진 BaseballNumbers 객체
     */

    public static BaseballNumbers getComputerBaseballNumbers() {
        List<BaseballNumber> computerBaseballNumberList = new ArrayList<>();
        while (computerBaseballNumberList.size() != BASEBALL_NUMBERS_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_BASEBALL_NUMBER, MAX_BASEBALL_NUMBER);
            BaseballNumber randomBaseballNumber = new BaseballNumber(randomNumber);
            if (!computerBaseballNumberList.contains(randomBaseballNumber)) {
                computerBaseballNumberList.add(randomBaseballNumber);
            }
        }
        return new BaseballNumbers(computerBaseballNumberList);
    }

    /**
     * 유저에게 입력받은 값을 BaseballNumbers 객체로 변환 후 반환
     *
     * @param baseballStringNumbers 유저가 입력한 숫자 야구 값
     * @return 유저에게 입력받은 값으로 만든 BaseballNumbers 객체
     */

    public static BaseballNumbers getUserBaseballNumbers(StringNumbers baseballStringNumbers) {
        return new BaseballNumbers(baseballStringNumbers.translateToIntegerList()
                .stream()
                .map(BaseballNumber::new)
                .collect(Collectors.toList()));
    }
}
