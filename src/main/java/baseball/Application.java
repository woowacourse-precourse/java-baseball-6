package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballGame baseballGame = new BaseballGame();
        Human user = new Human();
        baseballGame.start(user);
    }

}
