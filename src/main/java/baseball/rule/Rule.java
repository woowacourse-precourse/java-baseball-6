package baseball.rule;

import baseball.domain.result.Result;
import java.util.List;

public interface Rule {

    Result check(List<Integer> userNumber, List<Integer> computerNumber);
}
