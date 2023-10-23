package baseball.domain.hint;

import java.util.ArrayList;
import java.util.List;

public class Hint {

    private List<HintItem> hintItems = new ArrayList<>();

    public void addHintItem(HintItem hintItem) {
        hintItems.add(hintItem);
    }

}
