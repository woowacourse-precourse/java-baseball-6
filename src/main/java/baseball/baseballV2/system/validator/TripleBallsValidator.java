package baseball.baseballV2.system.validator;

import baseball.baseballV2.system.util.Util;
import java.util.List;

public class TripleBallsValidator {
    private final String validateTarget;

    public TripleBallsValidator(String input) {
        this.validateTarget = input;
        hasThreeDigits();
        hasDupulicatedNumber();
    }

    private void hasThreeDigits() {
        if (validateTarget.length() != 3) {
            throw new IllegalArgumentException("세개의 숫자로 구성되어 있지 않습니다.");
        }
    }

    private void hasDupulicatedNumber() {
        List<Character> characters = Util.StringToCharList(validateTarget);
        long removedSameNumber = characters.stream()
                .distinct().count();

        if (removedSameNumber != characters.size()) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다");
        }
    }
    // model 로직을 반영한 validator model에서 새로운 객체를 형성 시 호출한다
    // 서로 다른 3개의 수로 구성되어 있는지 확인한다

    // 3개의 수로 구성되어 있는지 확인하기
    // 중복된 수가 존재하는지 확인하기


}
