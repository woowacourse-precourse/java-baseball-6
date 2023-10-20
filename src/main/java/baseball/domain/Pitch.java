package baseball.domain;

import java.util.List;

public class Pitch extends DefaultData{
    public Pitch(List<Integer> inputNumberList) {
        super();
        if (!(inputNumberList.size() == MAX_LENGTH)) {
            throw new IllegalArgumentException();
        }
        setNumberList(inputNumberList);
    }
    public List<Integer> getPitches() {
        return numberList;
    }
}
