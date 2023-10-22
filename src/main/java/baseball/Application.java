package baseball;

import baseball.dto.Computer;
import baseball.service.Converter;
import baseball.service.Generator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while (true) {
            Computer computer = new Computer();
            Generator generator = new Generator();
            computer.setInput(generator.generateNum());
            computer.setComputerNumberBall(Converter.convert(computer.getInput()));


        }
    }
}
