package baseball;


public class Application {
    public static void main(String[] args) {
        boolean startFlag = true;
        while(startFlag){
            BaseBallGame newGame = new BaseBallGame();
            startFlag = newGame.gameStart();
        }
    }
}
