package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Controller {
    Game game = new Game();
    public void run() {
        Message.startmessage();
        game.startgame();
        Message.winmessage();
        Message.retryquestion();
        retry();
    }

    public void retry() {
        String retryinput = Console.readLine();
        int retrynumber = Converter.convertretrynumber(retryinput);
        if (retrynumber == 1) {
            run();
        }
    }
}
