package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Judger judger = new Judger();
        judger.startGame();
        Human human = new Human();
        human.getNumbers();
    }
}
