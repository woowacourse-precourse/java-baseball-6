package baseball;

public class Application {
    public static void main(String[] args) {
        BaseballGame game = new BaseballGame();
        boolean retry = true;
        while(retry){
            game.playGame();
            retry = game.retry();
        }
    }
}
