package baseball.view;

import java.io.IOException;

public interface OutPut {
    void gameStart() throws IOException;
    void print(String msg) throws IOException;
    void close() throws IOException;
}
