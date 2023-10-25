package service;

public interface GameService {

    void gameStart();
    void restartOrQuit(String order);
    int[] checkCount(String numbers);
    boolean isGameSet();
    boolean getQuit();
}
