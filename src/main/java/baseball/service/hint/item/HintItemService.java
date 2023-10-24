package baseball.service.hint.item;

import baseball.domain.NumberBaseball;
import baseball.domain.hint.item.HintItem;

public interface HintItemService { //TODO: 전체 코드 포맷 (Ctrl+Alt+L)

    HintItem create(NumberBaseball computerBaseball, NumberBaseball inputBaseball);
    int count(NumberBaseball computerBaseball, NumberBaseball inputBaseball);
    boolean isActive(HintItem hintItem);
}
