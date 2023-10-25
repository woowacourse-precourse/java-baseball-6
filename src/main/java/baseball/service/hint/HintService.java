package baseball.service.hint;

import baseball.domain.NumberBaseball;
import baseball.domain.hint.Hint;
import baseball.domain.hint.item.HintItem;
import java.util.List;

public interface HintService {

    Hint createHint(NumberBaseball computerBaseball, NumberBaseball inputBaseball);

    List<HintItem> createActiveHintItems(NumberBaseball computerBaseball, NumberBaseball inputBaseball);

    List<String> counts(Hint hint);

    List<String> names(Hint hint);
}
