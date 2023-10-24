package baseball.view;

import baseball.controller.hint.HintController;
import baseball.domain.hint.Hint;

import java.util.List;

public class HintView {

    public void displayHintMessage(Hint hint) {

        List<String> countList = HintController.counts(hint);
        List<String> nameList = HintController.names(hint);

        StringBuilder hintBuilder = new StringBuilder();

        for (int i = 0; i < countList.size(); i++) {
            hintBuilder.append(countList.get(i) + nameList.get(i));
            addSpaceIfNotEmpty(hintBuilder);
        }

        System.out.println(hintBuilder.toString());
    }

    private void addSpaceIfNotEmpty(StringBuilder stringBuilder) {
        if (!stringBuilder.isEmpty()) {
            stringBuilder.append(" ");
        }
    }

}
