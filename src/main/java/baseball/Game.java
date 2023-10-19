package baseball;

public class Game {
    Display display;
    public Game(){
        display = new Display();
        display.printStartText();
    }
    public void playGame(){
        boolean restartFlag = true;
        while(restartFlag) {
            int[] userInputs = display.getUserInput();
            boolean gameOver = true;
            if(gameOver){
                restartFlag = display.getRestartInput();
            }
        }

    }
}
