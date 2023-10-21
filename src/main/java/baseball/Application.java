package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while(true){
            BaseBallGame baseBallGame = new BaseBallGame();
            baseBallGame.play();
            if(!baseBallGame.isRestart())
                return;
        }
    }
}
