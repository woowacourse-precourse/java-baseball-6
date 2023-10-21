package baseball;

import baseball.dto.Computer;
import baseball.service.Generator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        while (true) {
            Computer computer = new Computer();
            Generator generator = new Generator();
            //System.out.println(logic.numToString());
            computer.setInput(generator.generateNum());

        }
    }
}
