package baseball.controller;

import baseball.domain.game.GameResult;
import baseball.view.output.HintView;
import io.Printer;

public final class OutputManager {

    private final Printer printer;

    public OutputManager(final Printer printer) {
        this.printer = printer;
    }

    public void printHint(final GameResult result) {
        printer.print(new HintView(result));
    }
}
