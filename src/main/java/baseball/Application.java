package baseball;

public class Application {
    public final static int NUMBER_LENGTH = 3;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballGame baseballGame = new BaseballGame();
        boolean run= true;
        while(run){
            if(baseballGame.gameStart()){
                run= baseballGame.restartOrEnd();
            }
        }
    }
}
