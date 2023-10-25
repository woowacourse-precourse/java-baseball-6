package baseball;

import baseball.domain.BaseballHandler;
import baseball.domain.Computer;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Computer computer = new Computer();
        BaseballHandler baseballHandler = new BaseballHandler(computer);
        baseballHandler.execute();
    }
}
