package baseball.service;

import baseball.domain.BaseballNumber;
import baseball.domain.BaseballScore;
import baseball.util.Util;
import baseball.validator.Validator;
import java.util.List;


/*
 *   야구 게임의 기능을 담당하는 클래스
 * */
public class BaseballService {
    private static final int COMPUTER_NUMBER_BEGIN = 1;
    private static final int COMPUTER_NUMBER_END = 9;
    private static final int COMPUTER_NUMBER_SIZE = 3;
    private static final String STRING_ONE = "1";

    public BaseballNumber initializeComputerNumber() {
        List<Integer> computerNumber = Util.createRandomNumberList(COMPUTER_NUMBER_SIZE, COMPUTER_NUMBER_BEGIN,
                COMPUTER_NUMBER_END);
        return new BaseballNumber(computerNumber);
    }

    public boolean isContinueGame(String inputRestartOrEnd) {
        Validator.validateStringIsOneOrTwo(inputRestartOrEnd);
        return inputRestartOrEnd.equals(STRING_ONE);
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
        Validator.validateStringLength(COMPUTER_NUMBER_SIZE, userNumber, "입력의 길이는 3이어야합니다.");
        Validator.validateStringHasNot("0", userNumber, "입력은 0을 포함할 수 없습니다.");
        Validator.validateStringAllDifferent(userNumber, "모든 입력된 값은 달라야합니다.");
    }

    public boolean isBaseballGameEnd(BaseballScore resultScore) {
        return resultScore.isStrikeThree();
    }

    public void showResultScore(BaseballScore resultScore) {
        resultScore.showBaseballScore();
    }
}
