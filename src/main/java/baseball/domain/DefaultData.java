package baseball.domain;

import java.util.List;

public abstract class DefaultData {
    protected final int MAX_LENGTH = 3;
    protected List<Integer> numberList;

    public void setNumberList(List<Integer> numberList) {
        this.numberList = numberList;
    }

}
