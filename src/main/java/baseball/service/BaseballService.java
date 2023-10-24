package baseball.service;

import baseball.model.Baseball;
import baseball.model.BaseballGameResult;
import baseball.model.BaseballNumber;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashSet;
import java.util.Set;

public class BaseballService {

    public Baseball createAnswerBaseball() {
        Set<Integer> uniqueNumbers = getUniqueNumbers();
        return Baseball.from(uniqueNumbers);
    }

    private Set<Integer> getUniqueNumbers() {
        Set<Integer> uniqueNumbers = new LinkedHashSet<>();

        while (uniqueNumbers.size() < Baseball.LENGTH) {
            int uniqueNumber = Randoms.pickNumberInRange(BaseballNumber.MIN_VALUE, BaseballNumber.MAX_VALUE);
            uniqueNumbers.add(uniqueNumber);
        }
        return uniqueNumbers;
    }

    public BaseballGameResult calculateResult(final Baseball answer, final Baseball guess) {
        return answer.match(guess);
    }
}
