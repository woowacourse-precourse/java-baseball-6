package baseball;

public class Application {
    public static void main(String[] args) {
        Printer printer = new BaseballPrinter();
        Computer computer = new BaseballComputer(printer);
        Game game = new Game(computer);

        System.out.println("숫자 야구 게임을 시작합니다.");
        game.start();
    }
}
