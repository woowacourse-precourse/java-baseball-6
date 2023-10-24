package baseball;

import baseball.computer.BaseballComputer;
import baseball.computer.Computer;
import baseball.printer.BaseballPrinter;
import baseball.printer.Printer;

public class Application {
    public static void main(String[] args) {
        Printer printer = new BaseballPrinter();
        Computer computer = new BaseballComputer(printer);
        Game game = new Game(computer);

        System.out.println("숫자 야구 게임을 시작합니다.");
        game.start();
    }
}
