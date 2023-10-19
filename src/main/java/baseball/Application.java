package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        do {
            Judger judger = new Judger();
            judger.startGame();
            Human human = new Human();
            human.getNumbers();
            Computer computer = new Computer();
            computer.getNumbers();
        } while (true);
    }
}
