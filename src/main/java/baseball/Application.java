package baseball;

import baseball.service.BaseballGameService;

public class Application {
    public static void main(String[] args) {
        BaseballGameService baseballGameService = new BaseballGameService();

        baseballGameService.setGame();
    }
}
