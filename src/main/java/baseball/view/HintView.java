package baseball.view;

import baseball.controller.HintController;
import baseball.domain.Hint.Ball;
import baseball.domain.Hint.Hint;
import baseball.domain.Hint.Nothing;
import baseball.domain.Hint.Strike;

import java.util.List;

public class HintView {

    public static void displayHintMessage(Hint hint) {

        List<String> countList = HintController.counts(hint);
        List<String> nameList = HintController.names(hint);

        StringBuilder hintBuilder = new StringBuilder();

        for (int i = 0; i < countList.size(); i++) {
            hintBuilder.append(countList.get(i) + nameList.get(i));
            addSpaceIfNotEmpty(hintBuilder);
        }

        System.out.println(hintBuilder.toString());
    }

    public static void addSpaceIfNotEmpty(StringBuilder stringBuilder) {
        if (!stringBuilder.isEmpty()) {
            stringBuilder.append(" ");
        }
    }

}
