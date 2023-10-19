package baseball;

import baseball.service.BallService;

public class Application {
    public static void main(String[] args) {
        BallService ballService = new BallService();
        ballService.init();
        ballService.start();
    }
}
