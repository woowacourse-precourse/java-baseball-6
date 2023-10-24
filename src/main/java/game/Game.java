package game;

public interface Game {

    public void start();
    public boolean gameInput(String num) throws IllegalArgumentException;
    public String gameoutput();
    public boolean getStatus();
    public boolean restart(String reinput) throws IllegalArgumentException;
}
