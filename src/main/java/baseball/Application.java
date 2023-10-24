package baseball;

import woowa.hyunho.messages.Messages;
import woowa.hyunho.process.Process;

public class Application {
    public static void main(String[] args) {
    	Messages.printStart();
        Process baseball = new Process();
        baseball.start();
    }
}