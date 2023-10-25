package baseball.domain.hint;

import baseball.domain.GameConstants;
import baseball.domain.hint.item.HintItem;
import baseball.util.StringUtil;
import java.util.ArrayList;
import java.util.List;

public class Hint {

    private List<HintItem> hintItems;

    private List<String> counts;
    private List<String> names;
    private boolean isCorrect;

    public List<HintItem> getHintItems() {
        return hintItems;
    }

    public List<String> getCounts() {
        return counts;
    }

    public List<String> getNames() {
        return names;
    }

    private Hint(List<HintItem> hintItems) {
        this.hintItems = hintItems;
        this.counts = counts();
        this.names = names();
        this.isCorrect = setCorrect();
    }

    public static Hint createHint(List<HintItem> hintItems) {
        return new Hint(hintItems);
    }

    private List<String> counts() {
        List<String> counts = new ArrayList<>();

        for (HintItem hintItem : hintItems) {
            if (hintItem.isActive()) {
                String stringCount = StringUtil.convertZeroToEmptyString(hintItem.getCount());
                counts.add(stringCount);
            }
        }
        return counts;
    }

    private List<String> names() {
        List<String> names = new ArrayList<>();

        for (HintItem hintItem : hintItems) {
            if (hintItem.isActive()) {
                names.add(hintItem.getName());
            }
        }
        return names;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    private boolean setCorrect() {
        return counts.contains(String.valueOf(GameConstants.NUMBER_LENGTH))
                && names.contains(GameConstants.STRIKE_TEXT);
    }
}
