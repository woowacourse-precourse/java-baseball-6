package service;

public interface GameService {

    public void gameStart();
    public void restartOrQuit(String order);
    public String checkCount(String numbers);
}
