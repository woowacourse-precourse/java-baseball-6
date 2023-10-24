package baseball.view;

import baseball.constants.Message;
import baseball.dto.output.ResultMessageDto;
import baseball.io.OutputWriter;

public class OutputView {

    private final OutputWriter writer;

    public OutputView(OutputWriter writer) {
        this.writer = writer;
    }

    public void startGame() {
        writer.writeLine(Message.START_GAME);
    }

    public void showGameResult(ResultMessageDto resultMessageDto) {
        writer.writeLine(resultMessageDto.toMessage());
    }

    public void clearGame() {
        writer.writeLine(Message.GAME_CLEAR);
    }
}
