package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        Human human = new Human();
        Computer computer = new Computer();

        computer.setNumbers();

        do {
            Judger judger = new Judger();

            human.setNumbers();

            judger.compareNumbers(human.getNumbers(), computer.getNumbers());
        } while (true);
    }
}
