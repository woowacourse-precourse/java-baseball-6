package baseball.service;

import baseball.domain.BaseballNumber;
import baseball.domain.BaseballScore;
import baseball.validator.Validator;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

// 숫자야구게임의 진행을 담당하는 클래스
public class BaseballService {
    public BaseballNumber initializeComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return new BaseballNumber(computer);
    }

    public boolean isContinueGame(String inputRestartOrEnd) {
        Validator.validateStringIsOneOrTwo(inputRestartOrEnd);
        return inputRestartOrEnd.equals("1");
    }

    public BaseballScore compareBaseballNumber(BaseballNumber computerNumber, BaseballNumber userNumber) {
        BaseballScore baseballScore = BaseballNumber.compareNumber(computerNumber, userNumber);
        return baseballScore;
    }

    public BaseballNumber initializeUserNumber(String userNumber) {
        validateUserNumber(userNumber);
        return new BaseballNumber(userNumber);
    }

    private void validateUserNumber(String userNumber) {
        Validator.validateStringIsNaturalNumber(userNumber, "자연수로만 입력되어야합니다.");
        Validator.validateStringLength(3, userNumber, "입력의 길이는 3이어야합니다.");
        Validator.validateStringHasNot("0", userNumber, "입력은 0을 포함할 수 없습니다.");
        Validator.validateStringAllDifferent(userNumber, "모든 입력된 값은 달라야합니다.");
    }
}
