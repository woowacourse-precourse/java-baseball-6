package baseball;

import woowa.hyunho.game.Process;
import woowa.hyunho.messages.Messages;

public class Application {
    public static void main(String[] args) {
    	Messages.printStart();
        Process baseball = new Process();
        baseball.start();
    }
}
