package baseball;

import static baseball.BaseballConstants.*;

public class BaseballGameView {

    private Reader reader;
    private Writer writer;

    public BaseballGameView(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public void showStartMessage(){
        writer.write(START_MESSAGE);
    }

    public void showEndMessage() {
        writer.write(END_MESSAGE);
    }

    public String inputNextGameNumber() {
        writer.write(NEXT_GAME_MESSAGE);
        return reader.read();
    }

    public void print(String str) {
        writer.write(str);
    }

    public String inputBaseballNumber() {
        writer.write(INPUT_MESSAGE);
        return reader.read();
    }


}
