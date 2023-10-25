package baseball.io;

import java.io.IOException;

public interface OutPut {
    void gameStart() throws IOException;
    void print(String msg) throws IOException;
    void printResult(int strikeCount, int ballCount) throws IOException;
    void collect(int strikeCount) throws IOException;
    void close() throws IOException;
}
