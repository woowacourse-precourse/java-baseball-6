package baseball.io;

import java.io.IOException;

public interface OutPut {
    void gameStart();
    void print(String msg) throws IOException;
    void printResult(int strikeCount, int ballCount) throws IOException;
    void close() throws IOException;
}
