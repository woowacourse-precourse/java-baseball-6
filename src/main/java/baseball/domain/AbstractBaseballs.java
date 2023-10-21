package baseball.domain;

import java.util.List;

abstract class AbstractBaseballs {
    protected static final int BASEBALLS_SIZE = 3;

    protected List<Baseball> baseballs;

    protected AbstractBaseballs(List<Baseball> baseballs) {
        this.baseballs = baseballs;
    }

}
