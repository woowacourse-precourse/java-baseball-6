package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Judger judger = new Judger();
        Human human = new Human();
        Computer computer = new Computer();

        computer.getNumbers();

        do {
            judger.startGame();
            human.getNumbers();

            judger.compareNumbers(human.numbers(), computer.numbers());
        } while (true);
    }
}
