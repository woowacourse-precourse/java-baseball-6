package baseball.view.core;

public sealed class ConsoleWriter permits InputView, OutputView {

    protected void println(final Object data) {
        System.out.println(data);
    }

    protected void newLine() {
        this.println("");
    }

    protected void print(final Object data) {
        System.out.print(data);

    }
}
