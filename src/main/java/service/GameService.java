package service;

public interface GameService {

    public void gameStart();
    public void restartOrQuit(String order);
    public int[] checkCount(String numbers);
    public boolean isGameSet();

    public boolean getQuit();
    public void setQuit(boolean quit);
}
