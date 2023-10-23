package game;

import java.io.IOException;

public interface Game {
    void gameInit();
    void gamePlay() throws IOException;
    void gameExit();
}
