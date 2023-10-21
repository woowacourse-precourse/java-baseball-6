package baseball;

 //countStrike countBall printResult
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballGame game = new BaseballGame();
        game.play();
    }
}

class BaseballGame {
    void play() {
        System.out.println("hello");
    }
}