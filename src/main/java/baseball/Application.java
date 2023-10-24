package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Balls computer = new Balls();
        Game baseballGame = new Game(computer);

        baseballGame.play();
    }
}
