package baseball.view;

import baseball.domain.hint.Hint;

import java.util.List;

public class HintView {

    public void displayHintMessage(List<String> countList, List<String> nameList) {
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
