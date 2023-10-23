package baseball.service.hint;

import baseball.domain.Baseball;
import baseball.domain.hint.HintItem;

public interface HintItemService<T extends HintItem> {

    int count(Baseball computerBaseball, Baseball inputBaseball);
    boolean active(T object);

}
