package baseball.controller;

import baseball.domain.ball.BallNumber;
import baseball.domain.game.GameStatus;
import baseball.parser.InputParser;
import baseball.view.input.BallNumbersView;
import baseball.view.input.NextGameStatusView;
import collection.Triple;
import io.Printer;
import io.Reader;

public final class InputManager {
    private final Printer printer;
    private final Reader reader;
    private final InputParser parser;
    private boolean isGameStart = true;

    public InputManager(
            final Printer printer,
            final Reader reader,
            final InputParser parser
    ) {
        this.printer = printer;
        this.reader = reader;
        this.parser = parser;
    }

    public Triple<BallNumber> inputBallNumbers() {
        printer.print(new BallNumbersView(isGameStart));
        isGameStart = false;
        return parser.parseBallNumbersInput(reader.readLine());
    }

    public GameStatus inputNextGameStatus() {
        printer.print(new NextGameStatusView());
        return parser.parseGameStatusInput(reader.readLine());
    }

}
