package baseball;

import baseball.controller.BaseBall;
import baseball.service.PrintService;

public class Application {
    public static void main(String[] args) {


        BaseBall baseBall = new BaseBall();
        PrintService printService = new PrintService();

        //밖의 매개변수는 제거했음
        while (true) {
            baseBall.playBall();
            boolean continueGame = printService.printAfterFinish();
            if (!continueGame) {
                break;
            }
        }
    }
}
