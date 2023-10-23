package baseball.view;

import baseball.constants.Message;
import baseball.io.InputReader;
import baseball.io.OutputWriter;

public class BaseballView {

    private final InputReader reader;
    private final OutputWriter writer;

    public BaseballView(InputReader reader, OutputWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public void startGame() {
        writer.writeLine(Message.START_GAME.getValue());
    }

    public String inputNumber() {
        writer.write(Message.INPUT_NUMBER.getValue());
        return reader.readLine();
    }

    public void showGameResult(String gameResult) {
        writer.writeLine(gameResult);
    }

    public void clearGame() {
        writer.writeLine(Message.GAME_CLEAR.getValue());
    }
}
