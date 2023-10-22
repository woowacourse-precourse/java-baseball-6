package baseball.domain;

import java.util.List;

public class Baseball<T> {
    protected List<T> values;

    public Baseball() {

    }

    public Baseball(List<T> values) {
        this.values = values;
    }

    public List<T> getValues() {
        return values;
    }

    public void setValues(List<T> values) {
        this.values = values;
    }
}
