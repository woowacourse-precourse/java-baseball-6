package baseball;

import baseball.service.BaseBallGameService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseBallGameService baseBallGameService = new BaseBallGameService();
        baseBallGameService.gameStart();
    }
}
