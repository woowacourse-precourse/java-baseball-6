package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Printer printer = new Printer();
        Computer computer = new Computer(printer);
        Game game = new Game(computer);

        System.out.println("숫자 야구 게임을 시작합니다.");
        game.start();
    }
}
