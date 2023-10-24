package baseball;

public class BaseballGame {

    private final int NUM_COUNT=3;
    private final int STRIKE=2;
    private final int BALL=1;
    private final int NOTHING=0;
    private int[] playerAnswer;
    private int[] computerAnswer;
    Game game;

    public BaseballGame(){
        game=new Game();
    }

    public void startBaseballGame(){
        GameInstructions.startInstruction();
        game.setComputerAnswer();
        computerAnswer= game.getComputerAnswer();
    }
}
