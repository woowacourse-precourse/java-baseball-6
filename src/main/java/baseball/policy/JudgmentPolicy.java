package baseball.policy;

import baseball.utility.Score;
import java.util.List;

public interface JudgmentPolicy {
    Score compareNumbers(List<Integer> computerNumbers, List<Integer> userNumbers);
}
