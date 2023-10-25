package baseball.ui.output.component;

public class OutputComponentImpl implements OutputComponent {
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
