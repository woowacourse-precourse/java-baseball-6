package baseball;

import java.util.List;

public class ComAnswer {
    private List<Integer> value;

    ComAnswer(List<Integer> value) {
        this.value = value;
    }

    void changeValue(List<Integer> value) {
        this.value = value;
    }

    int getSize() {
        return value.size();
    }

    Integer getValue(int index) {
        return value.get(index);
    }

    void clear() {
        value.clear();
    }

    boolean isContain(Integer number) {
        return value.contains(number);
    }
}
