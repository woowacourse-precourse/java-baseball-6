package baseball.model;

import static baseball.utils.BaseballConstantUtils.BASEBALL_NUMBERS_LENGTH;
import static baseball.utils.BaseballConstantUtils.MAX_BASEBALL_NUMBER;
import static baseball.utils.BaseballConstantUtils.MIN_BASEBALL_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 숫자야구 값을 담은 리스트를 포장한 객체를 생성해주는 클래스입니다.
 */

public class BaseballNumbersGenerator {

    /**
     * 컴퓨터의 숫자야구 값 리스트를 포장한 객체를 생성합니다.
     *
     * @return 무작위로 만들어진 숫자야구 값을 담은 리스트를 포장한 객체
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
     * 유저의 숫자야구 값 리스트를 포장한 객체를 생성합니다.
     *
     * @param baseballStringNumbers 유저가 입력한 숫자 야구 값
     * @return 유저의 숫자야구 값 리스트를 포장한 객체
     */

    public static BaseballNumbers getUserBaseballNumbers(StringNumbers baseballStringNumbers) {
        return new BaseballNumbers(baseballStringNumbers.translateToIntegerList()
                .stream()
                .map(BaseballNumber::new)
                .collect(Collectors.toList()));
    }
}
