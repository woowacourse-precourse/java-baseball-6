package baseball.view;

import java.util.List;

public class OutputView {
    public void displayString(String result) {
        System.out.println(result);
    }

    public void displayList(List<?> result) {
        result.stream().forEach(System.out::print);
    }
}
