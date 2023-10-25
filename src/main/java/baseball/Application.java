package baseball;

import baseball.controller.*;

public class Application
{
    public static void main(String[] args)
    {
        int replay;
        BaseballGame.start();
        do {
            BaseballGame.play();
            replay = BaseballGame.askReplay();
        } while (replay == 1);
    }
}
