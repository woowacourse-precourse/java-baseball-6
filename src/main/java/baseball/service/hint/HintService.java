package baseball.service.hint;

import baseball.domain.NumberBaseball;
import baseball.domain.hint.Hint;

public interface HintService {

    Hint createHint(NumberBaseball computerBaseball, NumberBaseball inputBaseball);
}
