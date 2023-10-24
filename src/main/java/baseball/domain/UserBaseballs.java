package baseball.domain;

import java.util.Collections;
import java.util.List;

public class UserBaseballs extends AbstractBaseballs {
    protected UserBaseballs(List<Baseball> baseballs) {
        super(baseballs);
    }

    public List<Baseball> getBaseballs() {
        // 불변
        return Collections.unmodifiableList(baseballs);
    }
}
